package com.app.featurez.impl

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.app.featurez.api.ModuleZApi
import com.app.featurez.impl.ui.FeatureZScreen

class ModuleZ : ModuleZApi {

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(ModuleZApi.Destinations.FeatureZ.route) {
            FeatureZScreen(modifier = modifier, onGoBackClick = {
                navController.popBackStack()
            })
        }
    }
}
