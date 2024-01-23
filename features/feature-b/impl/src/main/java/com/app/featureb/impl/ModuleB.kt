package com.app.featureb.impl

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.app.featurea.api.ModuleAApi
import com.app.featureb.api.ModuleBApi
import com.app.featureb.impl.ui.FeatureBScreen
import com.app.main.api.MainFeatureApi

class ModuleB : ModuleBApi {
    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(ModuleBApi.Destinations.FeatureB.route) {
            FeatureBScreen(
                modifier = modifier,
                onGoToMainClick = {
                    navController.navigate(MainFeatureApi.Destinations.Main.navigateTo()) {
                        popUpTo(ModuleAApi.Destinations.FeatureA.route) {
                            inclusive = true
                        }
                    }
                },
                onGoBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}
