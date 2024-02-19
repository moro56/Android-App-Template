package com.app.featurex

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.app.core.navigation.AppNavigator
import com.app.core.navigation.models.NavCommand
import com.app.core.navigation.models.NavScreen
import com.app.featurex.ui.FeatureXScreen

@Composable
fun FeatureX(appNavigator: AppNavigator, modifier: Modifier) {
    FeatureXScreen(
        modifier = modifier,
        onGoToCClick = {
            appNavigator.navigate(command = NavCommand.NavigateToRoute(NavScreen.FeatureC.route))
        }
    )
}
