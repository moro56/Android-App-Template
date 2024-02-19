package com.app.core.navigation

import androidx.navigation.NavController
import com.app.core.navigation.models.BottomSheetData
import com.app.core.navigation.models.NavCommand

/**
 * Navigator class
 */
abstract class Navigator {

    abstract val navController: NavController

    /**
     * Method for navigating to the correct destination
     *
     * @param command [NavCommand] that describes the destination
     */
    abstract fun navigate(command: NavCommand)
}

/**
 * Navigator class implementation
 *
 * @property navController navigation controller
 */
class AppNavigator(override val navController: NavController) : Navigator() {
    override fun navigate(command: NavCommand) {
        when (command) {
            NavCommand.GoBack -> navController.popBackStack()
            is NavCommand.GoBackToRoute -> navController.popBackStack(
                command.route,
                command.inclusive
            )

            is NavCommand.NavigateToRoute -> navController.navigate(
                command.route,
                navOptions = command.options
            )

            is NavCommand.OpenBottomSheet -> command.navigationState.showBottomSheet(
                BottomSheetData(
                    command.route,
                    command.params
                )
            )
        }
    }
}
