package com.mnhyim.gymetric.ui.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.FitnessCenter
import androidx.compose.material.icons.outlined.SportsMartialArts
import androidx.compose.material.icons.rounded.Info
import androidx.compose.ui.graphics.vector.ImageVector
import com.mnhyim.gymetric.ui.navigation.Routes

enum class SettingsItemEnum(
    val title: String,
    val subtitle: String,
    val icon: ImageVector,
    val route: Routes
) {
    MUSCLE_GROUP(
        title = "Muscle Group",
        subtitle = "Manage muscle group",
        icon = Icons.Outlined.SportsMartialArts,
        route = Routes.ManageMuscleGroup
    ),
    EXERCISES(
        title = "Exercises",
        subtitle = "Manage exercises",
        icon = Icons.Outlined.FitnessCenter,
        route = Routes.ManageExercises
    ),
    ABOUT(
        title = "About",
        subtitle = "About Developers",
        icon = Icons.Rounded.Info,
        route = Routes.Home
    )
}