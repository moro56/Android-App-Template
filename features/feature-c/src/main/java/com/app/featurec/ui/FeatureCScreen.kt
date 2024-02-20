package com.app.featurec.ui

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
 * Feature C screen
 *
 * @param modifier compose modifier
 * @param onGoBackClick trigger for navigating back
 */
@Composable
fun FeatureCScreen(modifier: Modifier, onGoBackClick: () -> Unit) {
    FeatureCScreenContent(modifier = modifier, onGoBackClick = onGoBackClick)
}

/**
 * Feature C screen content
 *
 * @param modifier compose modifier
 * @param onGoBackClick trigger for navigating back
 */
@Composable
fun FeatureCScreenContent(modifier: Modifier, onGoBackClick: () -> Unit) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(text = "Feature C")
            Button(onClick = onGoBackClick) {
                Text(text = "Go back")
            }
        }
    }
}

@PreviewDefaultLight
@Composable
fun FeatureCScreenContentPreview() {
    FeatureCScreenContent(Modifier) {}
}
