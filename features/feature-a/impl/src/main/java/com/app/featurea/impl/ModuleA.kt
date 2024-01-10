package com.app.featurea.impl

import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.app.featurea.api.ModuleAApi

class ModuleA : ModuleAApi {

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(ModuleAApi.Destinations.FeatureA.route) {
            Text(text = "Feature A")
        }
    }
}
