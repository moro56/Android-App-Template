package com.app.core.base.state

import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.Saver

// Global state
val LocalAppState = compositionLocalOf { GlobalState(false) }

class GlobalState(userLoggedIn: Boolean) {
    val isUserLoggedIn: Boolean = userLoggedIn

    // Show/hide bottom bar
    val bottomBarState by mutableStateOf(true)
}

val globalStateSaver = Saver<GlobalState, String>(
    save = {
        it.isUserLoggedIn.toString()
    },
    restore = {
        GlobalState(it.toBoolean())
    }
)