package com.app.featurec.api

import com.app.core.navigation.FeatureApi
import com.app.core.navigation.FeatureDestination

/**
 * Interface that defines the module C feature
 */
interface ModuleCApi : FeatureApi {

    sealed class Destinations {
        /**
         * Feature C screen
         */
        object FeatureC : Destinations(), FeatureDestination {
            override val route: String = "featureC"
        }
    }
}