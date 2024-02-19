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

    // Show/hide bottom bar
    var bottomBarVisible by mutableStateOf(true)
}

val globalStateSaver = Saver<GlobalState, String>(
    save = {
        "${it.userLoggedIn}|${it.bottomBarVisible}"
    },
    restore = {
        it.split("|").let {
            GlobalState().apply {
                userLoggedIn = it.firstOrNull()?.toBoolean() ?: false
                bottomBarVisible = it.lastOrNull()?.toBoolean() ?: true
            }
        }
    }
)
