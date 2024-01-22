package com.app.featurea.impl

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.app.core.navigation.Navigator
import com.app.featurea.api.ModuleAApi
import com.app.featurea.impl.ui.FeatureAScreen
import com.app.featureb.api.ModuleBApi
import com.app.featureb.api.ModuleBModalApi

class ModuleA : ModuleAApi {
    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(ModuleAApi.Destinations.FeatureA.route) {
            FeatureAScreen(
                modifier = modifier,
                onGoToBClick = {
                    navController.navigate(ModuleBApi.Destinations.FeatureB.navigateTo())
                },
                onShowFeatureBModalClick = {
                    Navigator.openModal(
                        ModuleBModalApi::class,
                        mapOf(ModuleBModalApi.param to "Feature B Modal")
                    )
                }
            )
        }
    }
}
