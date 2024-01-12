package com.app.main.impl.ui.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.Image
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.app.core.base.annotations.PreviewDefaultLight
import com.app.core.base.state.LocalAppState
import com.app.featurez.api.ModuleZApi
import com.app.main.impl.models.Screens

/**
 * Bottom navigation bar
 *
 * @param navController navigation controller
 */
@Composable
fun BottomNavBar(navController: NavHostController) {
    val screens = remember { screenList() }
    val globalState = LocalAppState.current
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    // Show or hide the navigation bar on navigation
    when (navBackStackEntry?.destination?.route) {
        ModuleZApi.Destinations.FeatureZ.route -> {
            globalState.bottomBarState = false
        }

        else -> {
            globalState.bottomBarState = true
        }
    }

    AnimatedVisibility(
        visible = globalState.bottomBarState,
        enter = slideInVertically(initialOffsetY = { it }),
        exit = slideOutVertically(targetOffsetY = { it })
    ) {
        NavigationBar {
            val currentRoute = navBackStackEntry?.destination?.route

            screens.forEach { screen ->
                val selected = currentRoute?.startsWith(screen.route) == true

                NavigationBarItem(
                    label = {
                        Text(text = stringResource(id = screen.title))
                    },
                    icon = {
                        Image(
                            imageVector = screen.icon,
                            contentDescription = stringResource(id = screen.title)
                        )
                    },
                    selected = selected,
                    onClick = {
                        navController.navigate(screen.route) {
                            navController.graph.findStartDestination().route?.also {
                                popUpTo(it) {
                                    inclusive = false
                                    saveState = true
                                }
                            }
                            launchSingleTop = true
                            restoreState = true
                        }
                    }
                )
            }
        }
    }
}

/**
 * Create the list of screens to show in bottom bar
 */
private fun screenList() = listOf(Screens.FeatureXScreen, Screens.FeatureYScreen)

@PreviewDefaultLight
@Composable
fun BottomNavBarPreview() {
    BottomNavBar(rememberNavController())
}