package com.app.featurex.impl.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.app.core.base.annotations.PreviewDefaultLight

/**
 * Feature X screen
 */
@Composable
fun FeatureXScreen() {
    FeatureXScreenContent()
}

/**
 * Feature X screen content
 */
@Composable
fun FeatureXScreenContent() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(text = "Feature X")
        }
    }
}

@PreviewDefaultLight
@Composable
fun FeatureXScreenContentPreview() {
    FeatureXScreenContent()
}