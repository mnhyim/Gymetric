package com.mnhyim.gymetric.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mnhyim.gymetric.ui.feature.ExerciseScreen
import com.mnhyim.gymetric.ui.feature.HomeScreen

@Composable
fun MainNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Routes.Home,
        modifier = modifier
    ) {
        composable<Routes.Home> {
            HomeScreen()
        }
        composable<Routes.Exercise> {
            ExerciseScreen()
        }
        composable<Routes.Statistic> {

        }
        composable<Routes.Settings> {

        }
    }
}