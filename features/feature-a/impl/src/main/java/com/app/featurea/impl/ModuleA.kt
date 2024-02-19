package com.app.featurea.impl

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.app.core.navigation.AppNavigator
import com.app.core.navigation.NavCommand
import com.app.core.navigation.NavScreen
import com.app.core.navigation.Navigator
import com.app.featurea.impl.ui.FeatureAScreen
import com.app.featureb.api.ModuleBModalApi

@Composable
fun FeatureA(appNavigator: AppNavigator, modifier: Modifier) {
    FeatureAScreen(
        modifier = modifier,
        onGoToBClick = {
            appNavigator.navigate(command = NavCommand.NavigateToRoute(NavScreen.FeatureB.route))
        },
        onShowFeatureBModalClick = {
            Navigator.openModal(
                ModuleBModalApi::class,
                mapOf(ModuleBModalApi.param to "Feature B Modal")
            )
        }
    )
}
