package com.app.featurea.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.app.core.base.annotations.PreviewDefaultLight
import com.app.ui.AppSnackBar
import com.app.ui.LocalSnackBarHostState
import com.app.ui.preview.ThemePreviewWrapper
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

/**
 * Feature A screen
 *
 * @param modifier compose modifier
 * @param onGoToBClick trigger for navigating to Feature B
 * @param onShowFeatureBModalClick trigger to show the Feature B Modal
 * @param viewModel viewModel
 */
@Composable
fun FeatureAScreen(
    modifier: Modifier,
    onGoToBClick: () -> Unit,
    onShowFeatureBModalClick: () -> Unit,
    viewModel: FeatureAViewModel = hiltViewModel()
) {
    val coroutineScope = rememberCoroutineScope()
    val snackBarHostState = LocalSnackBarHostState.current

    val uiState by viewModel.uiState.collectAsState()
    val uiEffect = viewModel.uiEffect

    LaunchedEffect(true) {
        uiEffect.collectLatest { effect ->
            when (effect) {
                FeatureAContract.Effect.ShowSnackBar -> {
                    coroutineScope.launch {
                        snackBarHostState.showSnackbar(message = "Effect example")
                    }
                }
            }
        }
    }

    Scaffold(snackbarHost = { AppSnackBar(state = snackBarHostState) }) {
        FeatureAScreenContent(
            modifier = modifier.padding(it),
            state = uiState,
            onGoToBClick = onGoToBClick,
            onCreateRandomNumberClick = {
                viewModel.sendEvent(FeatureAContract.Event.CreateRandomNumber)
            },
            onShowSnackBarClick = {
                viewModel.sendEvent(FeatureAContract.Event.ShowSnackBar)
            },
            onShowFeatureBModalClick = onShowFeatureBModalClick
        )
    }
}

/**
 * Feature A screen content
 *
 * @param modifier compose modifier
 * @param state feature state
 * @param onGoToBClick trigger for navigating to Feature B
 * @param onCreateRandomNumberClick trigger to creating a new random number
 * @param onShowSnackBarClick trigger to show the SnackBar
 * @param onShowFeatureBModalClick trigger to show the Feature B Modal
 */
@Composable
fun FeatureAScreenContent(
    modifier: Modifier,
    state: FeatureAContract.State,
    onGoToBClick: () -> Unit,
    onCreateRandomNumberClick: () -> Unit,
    onShowSnackBarClick: () -> Unit,
    onShowFeatureBModalClick: () -> Unit
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
            Text(
                modifier = Modifier.padding(top = 12.dp),
                text = "Random Number: ${state.number}"
            )
            Button(onClick = onCreateRandomNumberClick) {
                Text(text = "Create New Number")
            }
            Button(onClick = onShowSnackBarClick) {
                Text(text = "Show SnackBar")
            }
            Button(onClick = onShowFeatureBModalClick) {
                Text(text = "Show Feature B Modal")
            }
        }
    }
}

@PreviewDefaultLight
@Composable
fun FeatureAScreenContentPreview() {
    ThemePreviewWrapper {
        FeatureAScreenContent(Modifier.fillMaxSize(), FeatureAContract.State(0), {}, {}, {}) {}
    }
}
