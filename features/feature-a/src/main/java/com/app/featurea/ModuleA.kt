package com.app.featurea

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.app.core.navigation.AppNavigator
import com.app.core.navigation.LocalNavigationState
import com.app.core.navigation.models.NavBottomSheet
import com.app.core.navigation.models.NavCommand
import com.app.core.navigation.models.NavScreen
import com.app.featurea.ui.FeatureAScreen

@Composable
fun FeatureA(appNavigator: AppNavigator, modifier: Modifier) {
    val navigationState = LocalNavigationState.current

    FeatureAScreen(
        modifier = modifier,
        onGoToBClick = {
            appNavigator.navigate(command = NavCommand.NavigateToRoute(NavScreen.FeatureB.route))
        },
        onShowFeatureBModalClick = {
            appNavigator.navigate(
                command = NavCommand.OpenBottomSheet(
                    navigationState,
                    NavBottomSheet.FeatureB.route
                )
            )
        }
    )
}
