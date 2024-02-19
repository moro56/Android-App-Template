package com.app.core.navigation.models

import androidx.navigation.NavOptions
import com.app.core.navigation.NavigationState

/**
 * Class that defines all the command that can be used on the navigator
 */
sealed class NavCommand {
    /**
     * Navigate to route
     *
     * @property route destination route
     * @property options navigation options
     */
    data class NavigateToRoute(val route: String, val options: NavOptions? = null) : NavCommand()

    /**
     * Navigate back
     */
    data object GoBack : NavCommand()

    /**
     * Navigate back to route
     *
     * @property route destination route
     * @property inclusive whether the given destination should also be popped
     */
    data class GoBackToRoute(val route: String, val inclusive: Boolean) : NavCommand()

    /**
     * Open a bottomSheet
     *
     * @property navigationState navigation state
     * @property route bottomSheet route
     * @property params bottomSheet params
     */
    data class OpenBottomSheet(
        val navigationState: NavigationState,
        val route: String,
        val params: Map<String, String> = mapOf()
    ) : NavCommand()
}
