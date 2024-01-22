package com.app.featureb.api

import com.app.core.navigation.ModalFeatureApi

/**
 * Interface that defines the module B modal feature
 */
interface ModuleBModalApi : ModalFeatureApi {
    companion object {
        const val featureRoute: String = "modalFeatureB"
        const val param: String = "param"
    }
}
