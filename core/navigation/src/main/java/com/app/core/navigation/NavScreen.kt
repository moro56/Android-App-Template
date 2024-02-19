package com.app.core.navigation

import androidx.navigation.NamedNavArgument

sealed class NavScreen(val route: String, val arguments: List<NamedNavArgument> = emptyList()) {

    data object FeatureA : NavScreen(route = "featureA")

    data object FeatureB : NavScreen(route = "featureB")

    data object FeatureC : NavScreen(route = "featureC")

    data object FeatureX : NavScreen(route = "featureX")

    data object FeatureY : NavScreen(route = "featureY")

    data object FeatureZ : NavScreen(route = "featureZ")

    data object Main : NavScreen(route = "main")
}
