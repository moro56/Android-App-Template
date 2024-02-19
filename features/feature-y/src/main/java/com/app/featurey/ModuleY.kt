package com.app.featurey

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.app.core.navigation.AppNavigator
import com.app.core.navigation.models.NavCommand
import com.app.core.navigation.models.NavScreen
import com.app.featurey.ui.FeatureYScreen

@Composable
fun FeatureY(appNavigator: AppNavigator, modifier: Modifier) {
    FeatureYScreen(
        modifier = modifier,
        onGoToZClick = {
            appNavigator.navigate(command = NavCommand.NavigateToRoute(NavScreen.FeatureZ.route))
        }
    )
}
