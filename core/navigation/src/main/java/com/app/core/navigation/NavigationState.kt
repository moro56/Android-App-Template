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
     * @param data bottomSheet info
     */
    fun showBottomSheet(data: BottomSheetData) {
        bottomSheetData = data
    }

    /**
     * Hide the bottomSheet
     */
    fun hideBottomSheet() {
        bottomSheetData = null
    }
}
