package com.app.modular.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.BottomSheetDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetValue
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@ExperimentalMaterial3Api
@Composable
fun BottomSheetLayout(navController: NavHostController) {
    val coroutineScope = rememberCoroutineScope()

    // BottomSheet states
    var showSheet by remember { mutableStateOf(false) }
    var modalRoute by rememberSaveable { mutableStateOf("Test") }
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
                }
            }
        }
    }

    // Show BottomSheet lambda
    val showBottomSheet: (String, Map<String, String>) -> Unit = remember {
        { route, params ->
            modalRoute = route
            modalParams = params
            coroutineScope.launch {
                if (modalBottomSheetState.isVisible) {
                    modalBottomSheetState.hide()
                }
                delay(200)
                modalBottomSheetState.show()
            }
        }
    }

    if (showSheet) {
        ModalBottomSheet(
            sheetState = modalBottomSheetState,
            onDismissRequest = { showSheet = false },
            dragHandle = { BottomSheetDefaults.DragHandle() }) {
            BottomSheetContent(
                modifier = Modifier,
                route = modalRoute,
                navController = navController,
                showBottomSheet = showBottomSheet,
                hideBottomSheet = hideBottomSheet,
                params = modalParams
            )
        }
    }
}

@Composable
fun BottomSheetContent(
    modifier: Modifier,
    route: String,
    navController: NavHostController,
    showBottomSheet: (String, Map<String, String>) -> Unit,
    hideBottomSheet: () -> Unit,
    params: Map<String, String>
) {
    Box {
        when (route) {
            else -> Box(modifier = modifier.fillMaxSize()) {
                Text(text = "Test")
            }
        }
    }
}
