package com.app.featurec.impl

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.app.core.navigation.AppNavigator
import com.app.core.navigation.NavCommand
import com.app.featurec.impl.ui.FeatureCScreen

@Composable
fun FeatureC(appNavigator: AppNavigator, modifier: Modifier) {
    FeatureCScreen(
        modifier = modifier,
        onGoBackClick = {
            appNavigator.navigate(command = NavCommand.GoBack)
        }
    )
}
