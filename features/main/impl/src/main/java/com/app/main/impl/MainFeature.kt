package com.app.main.impl

import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.app.main.api.MainFeatureApi
import com.app.main.impl.ui.MainScreen

class MainFeature : MainFeatureApi {

    override fun registerGraph(
        navGraphBuilder: NavGraphBuilder,
        navController: NavController,
        modifier: Modifier
    ) {
        navGraphBuilder.composable(MainFeatureApi.Destinations.Main.route) {
            MainScreen()
        }
    }
}
