package com.app.featurea.impl

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.app.featurea.api.ModuleAApi
import com.app.featurea.impl.ui.FeatureAScreen
import com.app.featureb.api.ModuleBApi
import com.app.featurec.api.ModuleCApi

class ModuleA : ModuleAApi {

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(ModuleAApi.Destinations.FeatureA.route) {
            FeatureAScreen(onGoToBClick = {
                navController.navigate(ModuleBApi.Destinations.FeatureB.navigateTo())
            }, onGoToCClick = {
                navController.navigate(ModuleCApi.Destinations.FeatureC.navigateTo())
            })
        }
    }
}
