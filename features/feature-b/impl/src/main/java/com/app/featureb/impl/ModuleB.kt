package com.app.featureb.impl

import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.app.featureb.api.ModuleBApi

class ModuleB : ModuleBApi {

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(ModuleBApi.Destinations.FeatureB.route) {
            Text(text = "Feature B")
        }
    }
}
