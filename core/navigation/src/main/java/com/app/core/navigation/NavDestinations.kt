package com.app.core.navigation

import androidx.navigation.NamedNavArgument

/**
 * Single navigation destination
 *
 * @property route destination route
 */
interface FeatureDestination {
    val route: String
}

/**
 * Navigation destination with arguments
 *
 * @property arguments destination arguments
 * @property routePrefix destination route prefix
 */
interface FeatureDestinationWithArgs : FeatureDestination {
    val arguments: List<NamedNavArgument>
    val routePrefix: String
}
