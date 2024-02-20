package com.app.featureb

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.app.core.navigation.LocalNavigationState
import com.app.core.navigation.models.NavModalDestination
import com.app.featureb.ui.ModalFeatureBScreen

@Composable
fun FeatureBBottomSheet(
    modifier: Modifier,
    params: Map<String, String>
) {
    val navigationState = LocalNavigationState.current

    ModalFeatureBScreen(
        modifier = modifier,
        title = params[NavModalDestination.FeatureB.paramTitle] ?: "",
        onCloseClick = {
            navigationState.hideBottomSheet()
        }
    )
}
