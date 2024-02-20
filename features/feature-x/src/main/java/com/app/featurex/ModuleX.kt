package com.app.featurex

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.app.core.navigation.Navigator
import com.app.core.navigation.models.NavCommand
import com.app.core.navigation.models.NavDestination
import com.app.featurex.ui.FeatureXScreen

@Composable
fun FeatureX(appNavigator: Navigator, modifier: Modifier) {
    FeatureXScreen(
        modifier = modifier,
        onGoToCClick = {
            appNavigator.navigate(command = NavCommand.NavigateToRoute(NavDestination.FeatureC.route))
        }
    )
}
