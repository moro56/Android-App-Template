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
import com.app.core.navigation.NavScreen
import com.app.featurea.impl.FeatureA
import com.app.featureb.impl.FeatureB
import com.app.main.impl.MainFeature

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
        startDestination = NavScreen.FeatureA.route
    ) {
        composable(NavScreen.FeatureA.route) {
            FeatureA(appNavigator = appNavigator, modifier = modifier)
        }
        composable(NavScreen.FeatureB.route) {
            FeatureB(appNavigator = appNavigator, modifier = modifier)
        }
        composable(NavScreen.Main.route) {
            MainFeature(modifier = modifier)
        }
//        register(
//            Navigator.retrieveFeature(MainFeatureApi::class),
//            navController = navController,
//            modifier = modifier
//        )
//        register(
//            Navigator.retrieveFeature(ModuleAApi::class),
//            navController = navController,
//            modifier = modifier
//        )
//        register(
//            Navigator.retrieveFeature(ModuleBApi::class),
//            navController = navController,
//            modifier = modifier
//        )
    }
}
