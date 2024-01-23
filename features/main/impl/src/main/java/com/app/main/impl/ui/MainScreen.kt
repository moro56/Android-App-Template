package com.app.main.impl.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.app.core.base.annotations.PreviewDefaultLight
import com.app.main.impl.navigation.MainGraph
import com.app.main.impl.ui.components.BottomNavBar
import com.app.ui.AppSnackBar
import com.app.ui.LocalSnackBarHostState

/**
 * Main screen
 *
 * @param modifier compose modifier
 * @param navController navigation controller
 */
@Composable
fun MainScreen(modifier: Modifier, navController: NavHostController = rememberNavController()) {
    val snackBarHostState = LocalSnackBarHostState.current

    Scaffold(
        modifier = modifier,
        snackbarHost = {
            AppSnackBar(state = snackBarHostState)
        },
        bottomBar = {
            BottomNavBar(navController = navController)
        }
    ) {
        MainGraph(
            navController = navController,
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        )
    }
}

@PreviewDefaultLight
@Composable
fun MainScreenPreview() {
    MainScreen(Modifier)
}
