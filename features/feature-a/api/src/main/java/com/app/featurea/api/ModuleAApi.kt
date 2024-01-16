package com.app.featurea.api

import com.app.core.navigation.FeatureApi
import com.app.core.navigation.FeatureDestination

/**
 * Interface that defines the module A feature
 */
interface ModuleAApi : FeatureApi {
    sealed class Destinations {
        /**
         * Feature A screen
         */
        object FeatureA : Destinations(), FeatureDestination {
            override val route: String = "featureA"

            /**
             * Navigate to Feature A screen
             */
            fun navigateTo() = route
        }
    }
}
