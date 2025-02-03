package com.mnhyim.gymetric.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
sealed class Routes(val route: String) {

    @Serializable
    data object Home : Routes("HOME")

    @Serializable
    data object Exercise : Routes("EXERCISE")

    @Serializable
    data object Statistic : Routes("STATISTIC")

    @Serializable
    data object Settings : Routes("SETTINGS")

    @Serializable
    data object ManageMuscleGroup : Routes("MANAGE_MUSCLE_GROUP")

    @Serializable
    data object ManageExercises : Routes("MANAGE_EXERCISE")
}