package com.app.featurec.impl

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.app.featurec.api.ModuleCApi
import com.app.featurec.impl.ui.FeatureCScreen

class ModuleC : ModuleCApi {

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(ModuleCApi.Destinations.FeatureC.route) {
            FeatureCScreen(onGoBack = {
                navController.popBackStack()
            })
        }
    }
}
