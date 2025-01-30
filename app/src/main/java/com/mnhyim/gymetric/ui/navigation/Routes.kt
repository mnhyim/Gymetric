package com.mnhyim.gymetric.ui.navigation

import kotlinx.serialization.Serializable

sealed class Routes {

    @Serializable
    data object Home: Routes()

    @Serializable
    data object Exercise: Routes()

    @Serializable
    data object Statistic: Routes()

    @Serializable
    data object Settings: Routes()
}