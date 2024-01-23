package com.app.featurex.impl

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.app.featurec.api.ModuleCApi
import com.app.featurex.api.ModuleXApi
import com.app.featurex.impl.ui.FeatureXScreen

class ModuleX : ModuleXApi {
    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(ModuleXApi.Destinations.FeatureX.route) {
            FeatureXScreen(modifier = modifier, onGoToCClick = {
                navController.navigate(ModuleCApi.Destinations.FeatureC.navigateTo())
            })
        }
    }
}
