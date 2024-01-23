package com.app.featureb.api

import com.app.core.navigation.FeatureApi
import com.app.core.navigation.FeatureDestination

/**
 * Interface that defines the module B feature
 */
interface ModuleBApi : FeatureApi {
    sealed class Destinations {
        /**
         * Feature B screen
         */
        object FeatureB : Destinations(), FeatureDestination {
            override val route: String = "featureB"

            /**
             * Navigate to Feature B screen
             */
            fun navigateTo() = route
        }
    }
}
