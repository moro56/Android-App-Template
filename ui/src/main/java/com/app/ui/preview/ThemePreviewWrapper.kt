package com.app.ui.preview

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import com.app.core.base.state.GlobalState
import com.app.core.base.state.LocalAppState
import com.app.core.base.state.globalStateSaver
import com.app.ui.LocalSnackBarHostState

@Composable
fun ThemePreviewWrapper(content: @Composable () -> Unit) {
    val snackBarHostState = remember { SnackbarHostState() }
    val globalState = rememberSaveable(saver = globalStateSaver) { GlobalState() }
    CompositionLocalProvider(
        LocalAppState provides globalState,
        LocalSnackBarHostState provides snackBarHostState,
        content = content
    )
}
