package com.mnhyim.gymetric.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.mnhyim.gymetric.ui.feature.ExerciseScreen
import com.mnhyim.gymetric.ui.feature.HomeScreen
import com.mnhyim.gymetric.ui.feature.SettingsScreen
import com.mnhyim.gymetric.ui.feature.settings.manage_exercise.ManageExerciseScreen
import com.mnhyim.gymetric.ui.feature.settings.manage_muscle.ManageMuscleGroupScreen

@Composable
fun MainNavHost(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = Routes.ManageMuscleGroup,
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
            SettingsScreen(
                onNavigate = { navController.navigate(it) }
            )
        }
        composable<Routes.ManageMuscleGroup> {
            ManageMuscleGroupScreen()
        }
        composable<Routes.ManageExercises> {
            ManageExerciseScreen()
        }
    }
}