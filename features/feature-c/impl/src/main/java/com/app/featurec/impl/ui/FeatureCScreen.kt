package com.app.featurec.impl.ui

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
 * Feature C screen
 *
 * @param onGoBackClick trigger for navigating back
 */
@Composable
fun FeatureCScreen(onGoBackClick: () -> Unit) {
    FeatureCScreenContent(onGoBackClick = onGoBackClick)
}

/**
 * Feature C screen content
 *
 * @param onGoBackClick trigger for navigating back
 */
@Composable
fun FeatureCScreenContent(onGoBackClick: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
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
    FeatureCScreenContent {}
}