package com.app.featurex.impl

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.app.core.navigation.AppNavigator
import com.app.core.navigation.NavCommand
import com.app.core.navigation.NavScreen
import com.app.featurex.impl.ui.FeatureXScreen

@Composable
fun FeatureX(appNavigator: AppNavigator, modifier: Modifier) {
    FeatureXScreen(
        modifier = modifier,
        onGoToCClick = {
            appNavigator.navigate(command = NavCommand.NavigateToRoute(NavScreen.FeatureC.route))
        }
    )
}
