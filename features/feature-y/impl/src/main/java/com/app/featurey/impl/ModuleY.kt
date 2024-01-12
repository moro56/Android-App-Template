package com.app.featurey.impl

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.app.featurey.api.ModuleYApi
import com.app.featurey.impl.ui.FeatureYScreen
import com.app.featurez.api.ModuleZApi

class ModuleY : ModuleYApi {

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(ModuleYApi.Destinations.FeatureY.route) {
            FeatureYScreen(modifier = modifier, onGoToZClick = {
                navController.navigate(ModuleZApi.Destinations.FeatureZ.navigateTo())
            })
        }
    }
}
