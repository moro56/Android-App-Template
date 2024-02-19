package com.app.featurey.impl

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.app.core.navigation.AppNavigator
import com.app.core.navigation.NavCommand
import com.app.core.navigation.NavScreen
import com.app.featurey.impl.ui.FeatureYScreen

@Composable
fun FeatureY(appNavigator: AppNavigator, modifier: Modifier) {
    FeatureYScreen(
        modifier = modifier,
        onGoToZClick = {
            appNavigator.navigate(command = NavCommand.NavigateToRoute(NavScreen.FeatureZ.route))
        }
    )
}
