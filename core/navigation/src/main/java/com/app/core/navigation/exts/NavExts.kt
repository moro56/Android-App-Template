package com.app.core.navigation.exts

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import com.app.core.navigation.FeatureApi

/**
 * Register the feature to the navigation graph
 *
 * @param featureApi the feature
 * @param navController navigation controller
 * @param modifier compose modifier
 */
fun NavGraphBuilder.register(
    featureApi: FeatureApi,
    navController: NavController,
    modifier: Modifier = Modifier
) {
    featureApi.registerGraph(
        navGraphBuilder = this,
        navController = navController,
        modifier = modifier
    )
}
