package com.app.modular.navigation

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import com.app.core.navigation.Navigator
import com.app.core.navigation.exts.register
import com.app.featurea.api.ModuleAApi
import com.app.featureb.api.ModuleBApi
import com.app.featurec.api.ModuleCApi

/**
 * NavHost component that defines the navigation graph
 *
 * @param modifier compose modifier
 * @param navController navigation controller
 */
@Composable
fun AppNavGraph(modifier: Modifier = Modifier, navController: NavHostController) {
    NavHost(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        navController = navController,
        startDestination = ModuleAApi.Destinations.FeatureA.route
    ) {
        register(
            Navigator.retrieveFeature(ModuleAApi::class),
            navController = navController,
            modifier = modifier
        )
        register(
            Navigator.retrieveFeature(ModuleBApi::class),
            navController = navController,
            modifier = modifier
        )
        register(
            Navigator.retrieveFeature(ModuleCApi::class),
            navController = navController,
            modifier = modifier
        )
    }
}