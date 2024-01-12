package com.app.featurea.impl.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.app.core.base.annotations.PreviewDefaultLight

/**
 * Feature A screen
 *
 * @param onGoToBClick trigger for navigating to Feature B
 */
@Composable
fun FeatureAScreen(onGoToBClick: () -> Unit) {
    FeatureAScreenContent(onGoToBClick = onGoToBClick)
}

/**
 * Feature A screen content
 *
 * @param onGoToBClick trigger for navigating to Feature B
 */
@Composable
fun FeatureAScreenContent(onGoToBClick: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(text = "Feature A")
            Button(onClick = onGoToBClick) {
                Text(text = "Go to B")
            }
        }
    }
}

@PreviewDefaultLight
@Composable
fun FeatureAScreenContentPreview() {
    FeatureAScreenContent {}
}