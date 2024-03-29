package com.app.main.models

import androidx.annotation.StringRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector
import com.app.core.navigation.models.NavDestination

sealed class Screens(val route: String, @StringRes val title: Int, val icon: ImageVector) {
    data object FeatureXScreen : Screens(
        NavDestination.FeatureX.route,
        android.R.string.copy,
        Icons.Filled.Home
    )

    data object FeatureYScreen : Screens(
        NavDestination.FeatureY.route,
        android.R.string.cancel,
        Icons.Filled.Settings
    )
}
