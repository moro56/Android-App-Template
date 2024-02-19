package com.app.modular.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ModalBottomSheet
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
import com.app.core.navigation.LocalNavigationState
import com.app.core.navigation.models.NavBottomSheet
import com.app.featureb.FeatureBBottomSheet
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * BottomSheet
 */
@Composable
fun BottomSheetLayout() {
    val navigationState = LocalNavigationState.current
    val coroutineScope = rememberCoroutineScope()

    // BottomSheet states
    var showSheet by remember { mutableStateOf(false) }
    var modalRoute by rememberSaveable { mutableStateOf("") }
    var modalParams by rememberSaveable { mutableStateOf(mapOf<String, String>()) }
    val modalBottomSheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true,
        confirmValueChange = { it != SheetValue.PartiallyExpanded }
    )

    // Show/Hide bottomSheet logic
    LaunchedEffect(navigationState.bottomSheetData) {
        when (val state = navigationState.bottomSheetData) {
            null -> coroutineScope.launch {
                modalBottomSheetState.hide()
                showSheet = false
            }

            else -> {
                showSheet = true
                modalRoute = state.route
                modalParams = state.params
                coroutineScope.launch {
                    if (modalBottomSheetState.isVisible) {
                        modalBottomSheetState.hide()
                    }
                    delay(100)
                    modalBottomSheetState.show()
                }
            }
        }
    }

    if (showSheet) {
        ModalBottomSheet(
            sheetState = modalBottomSheetState,
            onDismissRequest = { navigationState.hideBottomSheet() },
            dragHandle = { BottomSheetDefaults.DragHandle() }
        ) {
            BottomSheetContent(
                modifier = Modifier,
                route = modalRoute,
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
 * @param params optional params
 */
@Composable
fun BottomSheetContent(
    modifier: Modifier,
    route: String,
    params: Map<String, String>
) {
    Box {
        when (route) {
            NavBottomSheet.FeatureB.route -> FeatureBBottomSheet(
                modifier = modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.97f)
                    .testTag("Feature2BottomSheet"),
                params = params
            )

            else -> Box(
                modifier = modifier
                    .fillMaxSize()
                    .testTag("EmptyBottomSheet")
            ) {}
        }
    }
}
