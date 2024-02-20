package com.app.featurez

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.app.core.navigation.Navigator
import com.app.core.navigation.models.NavCommand
import com.app.featurez.ui.FeatureZScreen

@Composable
fun FeatureZ(appNavigator: Navigator, modifier: Modifier) {
    FeatureZScreen(
        modifier = modifier,
        onGoBackClick = {
            appNavigator.navigate(command = NavCommand.GoBack)
        }
    )
}
