package com.app.featurey

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.app.core.navigation.Navigator
import com.app.core.navigation.models.NavCommand
import com.app.core.navigation.models.NavDestination
import com.app.featurey.ui.FeatureYScreen

@Composable
fun FeatureY(appNavigator: Navigator, modifier: Modifier) {
    FeatureYScreen(
        modifier = modifier,
        onGoToZClick = {
            appNavigator.navigate(command = NavCommand.NavigateToRoute(NavDestination.FeatureZ.route))
        }
    )
}
