package com.app.featurey.impl.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.app.core.base.annotations.PreviewDefaultLight

/**
 * Feature Y screen
 *
 * @param modifier compose modifier
 * @param onGoToZClick trigger for navigating to Feature Z
 */
@Composable
fun FeatureYScreen(modifier: Modifier, onGoToZClick: () -> Unit) {
    FeatureYScreenContent(modifier = modifier, onGoToZClick = onGoToZClick)
}

/**
 * Feature Y screen content
 *
 * @param modifier compose modifier
 * @param onGoToZClick trigger for navigating to Feature Z
 */
@Composable
fun FeatureYScreenContent(modifier: Modifier, onGoToZClick: () -> Unit) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(text = "Feature Y")
            Button(onClick = onGoToZClick) {
                Text(text = "Go to Z")
            }
        }
    }
}

@PreviewDefaultLight
@Composable
fun FeatureYScreenContentPreview() {
    FeatureYScreenContent(Modifier) {}
}
