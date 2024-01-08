package com.app.core.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

/**
 * Interface that defines a modal feature
 *
 * @property featureRoute route id
 * @property show show this feature modal
 */
interface ModalFeatureApi {

    val featureRoute: String
    var show: (currentRoute: String, params: Map<String, String>) -> Unit

    /**
     * Register the feature to the navigation graph
     *
     * @param navGraphBuilder navigation graph builder
     * @param navController navigation controller
     * @param modifier compose modifier
     */
    fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavController,
        modifier: Modifier = Modifier
    )
}