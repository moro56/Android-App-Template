package com.app.main.navigation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.core.navigation.AppNavigator
import com.app.core.navigation.NavScreen
import com.app.featurec.FeatureC
import com.app.featurex.FeatureX
import com.app.featurey.FeatureY
import com.app.featurez.FeatureZ

@Composable
fun MainGraph(navController: NavHostController, modifier: Modifier) {
    val appNavigator = remember { AppNavigator(navController = navController) }

    NavHost(
        modifier = Modifier.fillMaxSize(),
        navController = navController,
        route = NavScreen.Main.route,
        startDestination = NavScreen.FeatureX.route
    ) {
        composable(NavScreen.FeatureC.route) {
            FeatureC(appNavigator = appNavigator, modifier = modifier)
        }
        composable(NavScreen.FeatureX.route) {
            FeatureX(appNavigator = appNavigator, modifier = modifier)
        }
        composable(NavScreen.FeatureY.route) {
            FeatureY(appNavigator = appNavigator, modifier = modifier)
        }
        composable(NavScreen.FeatureZ.route) {
            FeatureZ(appNavigator = appNavigator, modifier = modifier.fillMaxSize())
        }
    }
}
