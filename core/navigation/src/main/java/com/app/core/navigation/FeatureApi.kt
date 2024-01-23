package com.app.core.navigation

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

/**
 * Interface that defines a feature
 */
interface FeatureApi {
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
