package com.mnhyim.gymetric

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDestination.Companion.hasRoute
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.mnhyim.gymetric.ui.components.CustomBottomNavigationBar
import com.mnhyim.gymetric.ui.navigation.MainNavHost
import com.mnhyim.gymetric.ui.navigation.Routes
import com.mnhyim.gymetric.ui.theme.GymetricTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val navBackStackEntry by navController.currentBackStackEntryAsState()

            GymetricTheme {
                Scaffold(
                    bottomBar = {
                        if (checkBottomBar(navBackStackEntry)) {
                            CustomBottomNavigationBar(
                                checkCurrentRoute = {
                                    checkCurrentRoute(
                                        navBackStackEntry,
                                        it
                                    )
                                },
                                onClick = { navController.navigate(it) }
                            )
                        }
                    },
                    modifier = Modifier
                        .fillMaxSize()
                        .imePadding()
                ) { innerPadding ->
                    MainNavHost(
                        navController = navController,
                        modifier = Modifier.padding(bottom = innerPadding.calculateBottomPadding())
                    )
                }
            }
        }
    }
}

fun checkCurrentRoute(navBackStackEntry: NavBackStackEntry?, route: Routes): Boolean {
    return navBackStackEntry?.destination?.hierarchy?.any { it.hasRoute(route::class) } ?: false
}

fun checkBottomBar(navBackStackEntry: NavBackStackEntry?): Boolean {
    val showBottomBar = listOf(
        Routes.Home,
        Routes.Exercise,
        Routes.Statistic,
        Routes.Settings
    )
    return navBackStackEntry?.destination?.let { dest ->
        showBottomBar.any { dest.hasRoute(it::class) }
    } == true
}