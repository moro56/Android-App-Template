package com.app.featureb

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.navOptions
import com.app.core.navigation.AppNavigator
import com.app.core.navigation.models.NavCommand
import com.app.core.navigation.models.NavScreen
import com.app.featureb.ui.FeatureBScreen

@Composable
fun FeatureB(appNavigator: AppNavigator, modifier: Modifier) {
    FeatureBScreen(
        modifier = modifier,
        onGoToMainClick = {
            appNavigator.navigate(
                command = NavCommand.NavigateToRoute(
                    NavScreen.Main.route,
                    options = navOptions {
                        popUpTo(NavScreen.FeatureA.route) {
                            inclusive = true
                        }
                    }
                )
            )
        },
        onGoBackClick = {
            appNavigator.navigate(command = NavCommand.GoBack)
        }
    )
}
