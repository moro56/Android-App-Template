package com.app.modular.navigation

import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.app.core.navigation.AppNavigator
import com.app.core.navigation.models.NavDestination
import com.app.featurea.FeatureA
import com.app.featureb.FeatureB
import com.app.main.MainFeature

/**
 * NavHost component that defines the navigation graph
 *
 * @param modifier compose modifier
 * @param navController navigation controller
 */
@Composable
fun AppNavGraph(modifier: Modifier = Modifier, navController: NavHostController) {
    val appNavigator = remember { AppNavigator(navController = navController) }

    NavHost(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(),
        navController = navController,
        startDestination = NavDestination.FeatureA.route
    ) {
        composable(NavDestination.FeatureA.route) {
            FeatureA(appNavigator = appNavigator, modifier = modifier)
        }
        composable(
            NavDestination.FeatureB.completeRoute,
            arguments = NavDestination.FeatureB.arguments
        ) {
            FeatureB(appNavigator = appNavigator, modifier = modifier)
        }
        composable(NavDestination.Main.route) {
            MainFeature(modifier = modifier)
        }
    }
}
