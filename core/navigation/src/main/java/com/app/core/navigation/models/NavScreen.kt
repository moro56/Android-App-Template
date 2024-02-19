package com.app.core.navigation.models

import androidx.navigation.NamedNavArgument

/**
 * Class that defines all the features route
 *
 * @property route route of the feature
 * @property arguments arguments of the feature
 */
sealed class NavScreen(val route: String, val arguments: List<NamedNavArgument> = emptyList()) {
    /**
     * Feature A
     */
    data object FeatureA : NavScreen(route = "featureA")

    /**
     * Feature B
     */
    data object FeatureB : NavScreen(route = "featureB")

    /**
     * Feature C
     */
    data object FeatureC : NavScreen(route = "featureC")

    /**
     * Feature X
     */
    data object FeatureX : NavScreen(route = "featureX")

    /**
     * Feature Y
     */
    data object FeatureY : NavScreen(route = "featureY")

    /**
     * Feature Z
     */
    data object FeatureZ : NavScreen(route = "featureZ")

    /**
     * Main
     */
    data object Main : NavScreen(route = "main")
}
