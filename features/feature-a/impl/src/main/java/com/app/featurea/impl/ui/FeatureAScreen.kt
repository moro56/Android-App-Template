package com.app.featurea.impl.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.app.core.base.annotations.PreviewDefaultLight

/**
 * Feature A screen
 *
 * @param modifier compose modifier
 * @param onGoToBClick trigger for navigating to Feature B
 * @param viewModel viewModel
 */
@Composable
fun FeatureAScreen(
    modifier: Modifier,
    onGoToBClick: () -> Unit,
    viewModel: FeatureAViewModel = hiltViewModel()
) {
    val uiState by viewModel.uiState.collectAsState()

    FeatureAScreenContent(
        modifier = modifier,
        state = uiState,
        onGoToBClick = onGoToBClick,
        onCreateRandomNumberClick = {
            viewModel.sendEvent(FeatureAContract.Event.CreateRandomNumber)
        }
    )
}

/**
 * Feature A screen content
 *
 * @param modifier compose modifier
 * @param state feature state
 * @param onGoToBClick trigger for navigating to Feature B
 * @param onCreateRandomNumberClick trigger to creating a new random number
 */
@Composable
fun FeatureAScreenContent(
    modifier: Modifier,
    state: FeatureAContract.State,
    onGoToBClick: () -> Unit,
    onCreateRandomNumberClick: () -> Unit
) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(text = "Feature A")
            Button(onClick = onGoToBClick) {
                Text(text = "Go to B")
            }
            Row(modifier = Modifier.padding(top = 12.dp)) {
                Text(text = "Random Number: ")
                Text(text = state.number.toString())
            }
            Button(onClick = onCreateRandomNumberClick) {
                Text(text = "Create New Number")
            }
        }
    }
}

@PreviewDefaultLight
@Composable
fun FeatureAScreenContentPreview() {
    FeatureAScreenContent(Modifier.fillMaxSize(), FeatureAContract.State(0), {}) {}
}
