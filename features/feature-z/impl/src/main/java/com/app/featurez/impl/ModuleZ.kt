package com.app.featurez.impl

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.app.core.navigation.AppNavigator
import com.app.core.navigation.NavCommand
import com.app.featurez.impl.ui.FeatureZScreen

@Composable
fun FeatureZ(appNavigator: AppNavigator, modifier: Modifier) {
    FeatureZScreen(
        modifier = modifier,
        onGoBackClick = {
            appNavigator.navigate(command = NavCommand.GoBack)
        }
    )
}
