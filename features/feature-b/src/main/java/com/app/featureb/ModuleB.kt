package com.app.featureb

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.navOptions
import com.app.core.navigation.Navigator
import com.app.core.navigation.models.NavCommand
import com.app.core.navigation.models.NavDestination
import com.app.featureb.ui.FeatureBScreen

@Composable
fun FeatureB(appNavigator: Navigator, modifier: Modifier) {
    val title: String
    val value: Int
    with(appNavigator.arguments) {
        title = this?.getString(NavDestination.FeatureB.paramTitle) ?: ""
        value = this?.getInt(NavDestination.FeatureB.paramValue) ?: 0
    }

    FeatureBScreen(
        modifier = modifier,
        titleSuffix = "$title$value",
        onGoToMainClick = {
            appNavigator.navigate(
                command = NavCommand.NavigateToRoute(
                    NavDestination.Main.route,
                    options = navOptions {
                        popUpTo(NavDestination.FeatureA.route) {
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
