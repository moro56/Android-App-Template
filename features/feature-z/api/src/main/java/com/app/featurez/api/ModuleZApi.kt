package com.app.featurez.api

import com.app.core.navigation.FeatureApi
import com.app.core.navigation.FeatureDestination

/**
 * Interface that defines the module Z feature
 */
interface ModuleZApi : FeatureApi {
    sealed class Destinations {
        /**
         * Feature Z screen
         */
        object FeatureZ : Destinations(), FeatureDestination {
            override val route: String = "featureZ"

            /**
             * Navigate to Feature Z screen
             */
            fun navigateTo() = route
        }
    }
}
