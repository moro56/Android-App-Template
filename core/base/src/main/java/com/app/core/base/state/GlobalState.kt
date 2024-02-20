package com.app.core.base.state

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver
import androidx.compose.runtime.setValue

// Global state
val LocalAppState = compositionLocalOf { GlobalState() }

class GlobalState {
    // User logged in state
    var userLoggedIn by mutableStateOf(false)
}

val globalStateSaver = Saver<GlobalState, String>(
    save = {
        it.userLoggedIn.toString()
    },
    restore = {
        GlobalState().apply {
            userLoggedIn = it.toBoolean()
        }
    }
)
