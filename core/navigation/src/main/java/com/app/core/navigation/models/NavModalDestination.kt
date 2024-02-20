package com.app.core.navigation.models

/**
 * Class that defines all the bottomSheet modals route
 *
 * @property route route of the bottomSheet
 */
sealed class NavModalDestination(val route: String) {
    /**
     * Feature B bottom sheet
     */
    data object FeatureB : NavModalDestination(route = "featureB") {
        const val paramTitle = "paramTitle"
    }
}
