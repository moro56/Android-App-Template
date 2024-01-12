package com.app.featurey.impl.ui

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
 * Feature Y screen
 */
@Composable
fun FeatureYScreen() {
    FeatureYScreenContent()
}

/**
 * Feature Y screen content
 */
@Composable
fun FeatureYScreenContent() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(text = "Feature Y")
        }
    }
}

@PreviewDefaultLight
@Composable
fun FeatureYScreenContentPreview() {
    FeatureYScreenContent()
}