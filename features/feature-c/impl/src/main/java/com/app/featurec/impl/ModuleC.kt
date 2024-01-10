package com.app.featurec.impl

import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.app.featurec.api.ModuleCApi

class ModuleC : ModuleCApi {

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(ModuleCApi.Destinations.FeatureC.route) {
            Text(text = "Feature C")
        }
    }
}
