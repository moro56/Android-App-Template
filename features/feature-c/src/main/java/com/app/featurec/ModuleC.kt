package com.app.featurec

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.app.core.navigation.Navigator
import com.app.core.navigation.models.NavCommand
import com.app.featurec.ui.FeatureCScreen

@Composable
fun FeatureC(appNavigator: Navigator, modifier: Modifier) {
    FeatureCScreen(
        modifier = modifier,
        onGoBackClick = {
            appNavigator.navigate(command = NavCommand.GoBack)
        }
    )
}
