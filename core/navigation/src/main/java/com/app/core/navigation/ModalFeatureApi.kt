package com.app.core.navigation

import androidx.compose.material3.SheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

/**
 * Interface that defines a modal feature
 *
 * @property featureRoute route id
 * @property show show this feature modal
 */
interface ModalFeatureApi {
    val featureRoute: String
    var show: (currentRoute: String, params: Map<String, String>) -> Unit

    /**
     * Define the content of the modal
     *
     * @param navController navigation controller
     * @param sheetState bottomSheet state
     * @param params optional params
     * @param onHide lambda for closing the modal
     * @param modifier compose modifier
     */
    @Composable
    fun ModalContent(
        navController: NavController,
        sheetState: SheetState,
        params: Map<String, String>,
        onHide: () -> Unit,
        modifier: Modifier
    )
}
