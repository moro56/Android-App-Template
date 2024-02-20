package com.app.core.navigation.models

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavType
import androidx.navigation.navArgument

/**
 * Class that defines all the features route
 *
 * @property route route of the feature
 * @property arguments arguments of the feature
 */
sealed class NavDestination(
    val route: String,
    open val arguments: List<NamedNavArgument> = emptyList()
) {
    /**
     * Feature A
     */
    data object FeatureA : NavDestination(route = "featureA")

    /**
     * Feature B
     */
    data object FeatureB : NavDestination(route = "featureB") {
        const val paramTitle = "paramTitle"
        const val paramValue = "paramValue"

        override val arguments = listOf(
            navArgument(paramTitle) { type = NavType.StringType },
            navArgument(paramValue) {
                type = NavType.IntType
                defaultValue = 0
            }
        )

        val completeRoute: String = route.appendArguments(arguments)

        /**
         * Create complete route with params
         *
         * @param title title
         * @param value value
         */
        fun createRoute(title: String, value: Int) =
            completeRoute.replace("{${arguments[0].name}}", title)
                .replace("{${arguments[1].name}}", value.toString())
    }

    /**
     * Feature C
     */
    data object FeatureC : NavDestination(route = "featureC")

    /**
     * Feature X
     */
    data object FeatureX : NavDestination(route = "featureX")

    /**
     * Feature Y
     */
    data object FeatureY : NavDestination(route = "featureY")

    /**
     * Feature Z
     */
    data object FeatureZ : NavDestination(route = "featureZ")

    /**
     * Main
     */
    data object Main : NavDestination(route = "main")

    /**
     * Create the complete route by appending the navigation arguments correctly
     *
     * @param arguments list of nav arguments
     */
    protected fun String.appendArguments(arguments: List<NamedNavArgument>): String {
        val mandatoryArguments = arguments.filter { it.argument.defaultValue == null }
            .takeIf { it.isNotEmpty() }
            ?.joinToString(separator = "/", prefix = "/") { "{${it.name}}" }
            .orEmpty()
        val optionalArguments = arguments.filter { it.argument.defaultValue != null }
            .takeIf { it.isNotEmpty() }
            ?.joinToString(separator = "&", prefix = "?") { "${it.name}={${it.name}}" }
            .orEmpty()
        return "$this$mandatoryArguments$optionalArguments"
    }
}
