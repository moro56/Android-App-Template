package com.app.featurea

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.app.core.navigation.LocalNavigationState
import com.app.core.navigation.Navigator
import com.app.core.navigation.models.NavCommand
import com.app.core.navigation.models.NavDestination
import com.app.core.navigation.models.NavModalDestination
import com.app.featurea.ui.FeatureAScreen

@Composable
fun FeatureA(appNavigator: Navigator, modifier: Modifier) {
    val navigationState = LocalNavigationState.current

    FeatureAScreen(
        modifier = modifier,
        onGoToBClick = {
            appNavigator.navigate(
                command = NavCommand.NavigateToRoute(
                    NavDestination.FeatureB.createRoute(
                        "Nav",
                        3
                    )
                )
            )
        },
        onShowFeatureBModalClick = {
            navigationState.showBottomSheet(NavModalDestination.FeatureB.route)
        }
    )
}
