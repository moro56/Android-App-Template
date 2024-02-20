package com.app.core.navigation

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import com.app.core.navigation.models.BottomSheetData

// Navigation state
val LocalNavigationState = compositionLocalOf { NavigationState() }

class NavigationState {
    // State of the bottomSheet, used for showing/hiding it.
    // Contains the minimum information for showing the correct one.
    var bottomSheetData by mutableStateOf<BottomSheetData?>(null)
        private set

    /**
     * Show the bottomSheet
     *
     * @param route route of the bottomSheet
     * @param params params
     */
    fun showBottomSheet(route: String, params: Map<String, String> = mapOf()) {
        bottomSheetData = BottomSheetData(route, params)
    }

    /**
     * Hide the bottomSheet
     */
    fun hideBottomSheet() {
        bottomSheetData = null
    }
}
