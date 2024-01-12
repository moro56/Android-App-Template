package com.app.featurey.api

import com.app.core.navigation.FeatureApi
import com.app.core.navigation.FeatureDestination

/**
 * Interface that defines the module Y feature
 */
interface ModuleYApi : FeatureApi {

    sealed class Destinations {
        /**
         * Feature Y screen
         */
        object FeatureY : Destinations(), FeatureDestination {
            override val route: String = "featureY"

            /**
             * Navigate to Feature Y screen
             */
            fun navigateTo() = route
        }
    }
}