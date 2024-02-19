package com.app.main.impl.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.app.core.navigation.NavScreen

sealed class Screens(val route: String, @StringRes val title: Int, val icon: ImageVector) {
    data object FeatureXScreen : Screens(
        NavScreen.FeatureX.route,
        android.R.string.copy,
        Icons.Filled.Home
    )

    data object FeatureYScreen : Screens(
        NavScreen.FeatureY.route,
        android.R.string.cancel,
        Icons.Filled.Settings
    )
}
