package com.app.main.impl.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.app.core.navigation.Navigator
import com.app.core.navigation.exts.register
import com.app.featurec.api.ModuleCApi
import com.app.featurex.api.ModuleXApi
import com.app.featurey.api.ModuleYApi
import com.app.featurez.api.ModuleZApi
import com.app.main.api.MainFeatureApi

@Composable
fun MainGraph(navController: NavHostController, modifier: Modifier) {
    NavHost(
        modifier = Modifier.fillMaxSize(),
        navController = navController,
        route = MainFeatureApi.Destinations.Main.route,
        startDestination = ModuleXApi.Destinations.FeatureX.route
    ) {
        register(
            Navigator.retrieveFeature(ModuleXApi::class),
            navController = navController,
            modifier = modifier
        )
        register(
            Navigator.retrieveFeature(ModuleYApi::class),
            navController = navController,
            modifier = modifier
        )
        register(
            Navigator.retrieveFeature(ModuleCApi::class),
            navController = navController,
            modifier = modifier
        )
        register(
            Navigator.retrieveFeature(ModuleZApi::class),
            navController = navController,
            modifier = Modifier.fillMaxSize()
        )
    }
}