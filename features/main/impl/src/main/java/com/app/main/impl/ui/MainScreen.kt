package com.app.main.impl.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.app.core.base.annotations.PreviewDefaultLight

/**
 * Main screen
 */
@Composable
fun MainScreen() {
    MainScreenContent()
}

/**
 * Main screen content
 */
@Composable
fun MainScreenContent() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {

    }
}

@PreviewDefaultLight
@Composable
fun MainScreenContentPreview() {
    MainScreenContent()
}