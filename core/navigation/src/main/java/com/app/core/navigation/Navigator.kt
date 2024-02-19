package com.app.core.navigation

import androidx.navigation.NavController

abstract class Navigator {

    abstract val navController: NavController

    abstract fun navigate(command: NavCommand)
}

class AppNavigator(override val navController: NavController) : Navigator() {
    override fun navigate(command: NavCommand) {
        when (command) {
            NavCommand.GoBack -> navController.popBackStack()
            is NavCommand.GoBackToRoute -> navController.popBackStack(
                command.route,
                command.inclusive
            )

            is NavCommand.NavigateToRoute -> navController.navigate(
                command.route,
                navOptions = command.options
            )
        }
    }
}

//object Navigator {
//    private val destinations = mutableMapOf<String, FeatureApi>()
//    private val modalDestinations = mutableMapOf<String, ModalFeatureApi>()
//
//    fun initialize(
//        features: List<FeatureApi>,
//        modalFeatures: List<ModalFeatureApi>
//    ) {
//        features.forEach {
//            registerFeature(it)
//        }
//        modalFeatures.forEach {
//            registerModalFeature(it)
//        }
//    }
//
//    private fun registerFeature(feature: FeatureApi) {
//        destinations[feature.javaClass.interfaces[0].name] = feature
//    }
//
//    private fun registerModalFeature(feature: ModalFeatureApi) {
//        modalDestinations[feature.javaClass.interfaces[0].name] = feature
//    }
//
//    @Suppress("UNCHECKED_CAST")
//    fun <T : FeatureApi> retrieveFeature(feature: KClass<T>): T =
//        destinations[feature.java.name]!! as T
//
//    @Suppress("UNCHECKED_CAST")
//    fun <T : ModalFeatureApi> retrieveModalFeature(feature: KClass<T>): T =
//        modalDestinations[feature.java.name]!! as T
//
//    fun <T : ModalFeatureApi> openModal(
//        feature: KClass<T>,
//        params: Map<String, String>
//    ) {
//        retrieveModalFeature(feature).also {
//            it.show.invoke(it.featureRoute, params)
//        }
//    }
//}
