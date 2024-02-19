package com.app.core.navigation

import androidx.navigation.NavOptions

sealed class NavCommand {
    data class NavigateToRoute(val route: String, val options: NavOptions? = null) : NavCommand()

    data object GoBack : NavCommand()

    data class GoBackToRoute(val route: String, val inclusive: Boolean) : NavCommand()
}