package com.app.featureb.impl.ui

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
 * Feature B screen
 *
 * @param onGoToMainClick trigger for navigating to Main
 * @param onGoBackClick trigger for navigating back
 */
@Composable
fun FeatureBScreen(onGoToMainClick: () -> Unit, onGoBackClick: () -> Unit) {
    FeatureBScreenContent(onGoToMainClick = onGoToMainClick, onGoBackClick = onGoBackClick)
}

/**
 * Feature B screen content
 *
 * @param onGoToMainClick trigger for navigating to Main
 * @param onGoBackClick trigger for navigating back
 */
@Composable
fun FeatureBScreenContent(onGoToMainClick: () -> Unit, onGoBackClick: () -> Unit) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(text = "Feature B")
            Button(onClick = onGoToMainClick) {
                Text(text = "Go to Main")
            }
            Button(onClick = onGoBackClick) {
                Text(text = "Go back")
            }
        }
    }
}

@PreviewDefaultLight
@Composable
fun FeatureBScreenContentPreview() {
    FeatureBScreenContent({}, {})
}