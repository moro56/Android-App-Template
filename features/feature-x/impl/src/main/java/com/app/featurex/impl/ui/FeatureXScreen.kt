package com.app.featurex.impl.ui

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
 * Feature X screen
 *
 * @param modifier compose modifier
 * @param onGoToCClick trigger for navigating to Feature C
 */
@Composable
fun FeatureXScreen(modifier: Modifier, onGoToCClick: () -> Unit) {
    FeatureXScreenContent(modifier = modifier, onGoToCClick = onGoToCClick)
}

/**
 * Feature X screen content
 *
 * @param modifier compose modifier
 * @param onGoToCClick trigger for navigating to Feature C
 */
@Composable
fun FeatureXScreenContent(modifier: Modifier, onGoToCClick: () -> Unit) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(text = "Feature X")
            Button(onClick = onGoToCClick) {
                Text(text = "Go to C")
            }
        }
    }
}

@PreviewDefaultLight
@Composable
fun FeatureXScreenContentPreview() {
    FeatureXScreenContent(Modifier) {}
}