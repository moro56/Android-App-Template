package com.app.core.navigation.models

/**
 * Class that defines all the bottomSheets route
 *
 * @property route route of the bottomSheet
 */
sealed class NavBottomSheet(val route: String) {
    /**
     * Feature B bottom sheet
     */
    data object FeatureB : NavBottomSheet(route = "featureB") {
        const val paramTitle = "paramTitle"
    }
}
