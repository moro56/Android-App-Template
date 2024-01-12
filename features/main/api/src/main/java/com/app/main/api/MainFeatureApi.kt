package com.app.main.api

import com.app.core.navigation.FeatureApi
import com.app.core.navigation.FeatureDestination

/**
 * Interface that defines the main feature
 */
interface MainFeatureApi : FeatureApi {

    sealed class Destinations {
        /**
         * Main screen
         */
        object Main : Destinations(), FeatureDestination {
            override val route: String = "main"

            /**
             * Navigate to main screen
             */
            fun navigateTo() = route
        }
    }
}