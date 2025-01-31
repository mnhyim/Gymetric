package com.mnhyim.gymetric.ui.util

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddChart
import androidx.compose.material.icons.filled.FitnessCenter
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.mnhyim.gymetric.ui.navigation.Routes

enum class BottomNavBarEnum(
    val route: Routes,
    val icon: ImageVector
) {
//    HOME(
//        route = Routes.Home,
//        icon = Icons.Default.Home
//    ),
    EXERCISE(
        route = Routes.Exercise,
        icon = Icons.Default.FitnessCenter
    ),
    STATISTIC(
        route = Routes.Statistic,
        icon = Icons.Default.AddChart
    ),
    SETTINGS(
        route = Routes.Settings,
        icon = Icons.Default.Settings
    )

}