package com.app.modular.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.navigation.NavHostController
import com.app.core.navigation.Navigator
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * BottomSheet
 *
 * @param navController navigation controller
 */
@Composable
fun BottomSheetLayout(navController: NavHostController) {
    val coroutineScope = rememberCoroutineScope()

    // BottomSheet states
    var showSheet by remember { mutableStateOf(false) }
    var modalRoute by rememberSaveable { mutableStateOf("") }
    var modalParams by rememberSaveable { mutableStateOf(mapOf<String, String>()) }
    val modalBottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true,
        confirmValueChange = { it != SheetValue.PartiallyExpanded }
    )

    // Hide BottomSheet lambda
    val hideBottomSheet: () -> Unit = remember {
        {
            if (modalBottomSheetState.isVisible) {
                coroutineScope.launch {
                    modalBottomSheetState.hide()
                    showSheet = false
                }
            }
        }
    }

    // Show BottomSheet lambda
    val showBottomSheet: (String, Map<String, String>) -> Unit = remember {
        { route, params ->
            showSheet = true
            modalRoute = route
            modalParams = params
            coroutineScope.launch {
                if (modalBottomSheetState.isVisible) {
                    modalBottomSheetState.hide()
                }
                delay(100)
                modalBottomSheetState.show()
            }
        }
    }

//    LaunchedEffect(true) {
//        // Feature B Modal
//        Navigator.retrieveModalFeature(ModuleBModalApi::class).apply {
//            show = showBottomSheet
//        }
//    }

    if (showSheet) {
        ModalBottomSheet(
            sheetState = modalBottomSheetState,
            onDismissRequest = { showSheet = false },
            dragHandle = { BottomSheetDefaults.DragHandle() }
        ) {
            BottomSheetContent(
                modifier = Modifier,
                route = modalRoute,
                navController = navController,
                sheetState = modalBottomSheetState,
                hideBottomSheet = hideBottomSheet,
                params = modalParams
            )
        }
    }
}

/**
 * BottomSheet content
 *
 * @param modifier compose modifier
 * @param route modal feature route
 * @param navController navigation controller
 * @param sheetState bottomSheet state
 * @param hideBottomSheet lambda for closing the modal
 * @param params optional params
 */
@Composable
fun BottomSheetContent(
    modifier: Modifier,
    route: String,
    navController: NavHostController,
    sheetState: SheetState,
    hideBottomSheet: () -> Unit,
    params: Map<String, String>
) {
//    val modalFeatureB = remember { Navigator.retrieveModalFeature(ModuleBModalApi::class) }

    Box {
        when (route) {
//            ModuleBModalApi.featureRoute -> modalFeatureB.ModalContent(
//                navController = navController,
//                sheetState = sheetState,
//                params = params,
//                onHide = hideBottomSheet,
//                modifier = modifier
//                    .fillMaxWidth()
//                    .fillMaxHeight(0.97f)
//                    .testTag("Feature2BottomSheet")
//            )

            else -> Box(modifier = modifier
                .fillMaxSize()
                .testTag("EmptyBottomSheet")) {}
        }
    }
}
