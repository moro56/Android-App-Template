package com.app.featurex.api

import com.app.core.navigation.FeatureApi
import com.app.core.navigation.FeatureDestination

/**
 * Interface that defines the module X feature
 */
interface ModuleXApi : FeatureApi {

    sealed class Destinations {
        /**
         * Feature X screen
         */
        object FeatureX : Destinations(), FeatureDestination {
            override val route: String = "featureX"

            /**
             * Navigate to Feature X screen
             */
            fun navigateTo() = route
        }
    }
}