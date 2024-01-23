package com.app.featureb.impl.ui

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
 * Modal Feature B screen
 *
 * @param modifier compose modifier
 * @param title screen title
 * @param onCloseClick trigger for closing the modal
 */
@Composable
fun ModalFeatureBScreen(modifier: Modifier, title: String, onCloseClick: () -> Unit) {
    ModalFeatureBScreenContent(
        modifier = modifier,
        title = title,
        onCloseClick = onCloseClick
    )
}

/**
 * Modal Feature B screen content
 *
 * @param modifier compose modifier
 * @param title screen title
 * @param onCloseClick trigger for closing the modal
 */
@Composable
fun ModalFeatureBScreenContent(
    modifier: Modifier,
    title: String,
    onCloseClick: () -> Unit
) {
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Text(text = title)
            Button(onClick = onCloseClick) {
                Text(text = "Close")
            }
        }
    }
}

@PreviewDefaultLight
@Composable
fun ModalFeatureBScreenContentPreview() {
    ModalFeatureBScreenContent(Modifier, "title") {}
}
