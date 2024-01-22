package com.app.featureb.impl

import androidx.compose.material3.SheetState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.app.featureb.api.ModuleBModalApi
import com.app.featureb.impl.ui.ModalFeatureBScreen

class ModalModuleB : ModuleBModalApi {

    override val featureRoute: String = ModuleBModalApi.featureRoute
    override var show: (currentRoute: String, params: Map<String, String>) -> Unit = { _, _ -> }

    @Composable
    override fun ModalContent(
        navController: NavController,
        sheetState: SheetState,
        params: Map<String, String>,
        onHide: () -> Unit,
        modifier: Modifier
    ) {
        val param = params[ModuleBModalApi.param]
        ModalFeatureBScreen(modifier = modifier, title = param ?: "", onCloseClick = onHide)
    }
}
