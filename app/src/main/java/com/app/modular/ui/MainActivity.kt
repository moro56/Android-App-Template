package com.app.modular.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Surface
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.app.core.base.state.GlobalState
import com.app.core.base.state.LocalAppState
import com.app.core.base.state.globalStateSaver
import com.app.core.navigation.LocalNavigationState
import com.app.core.navigation.NavigationState
import com.app.modular.navigation.AppNavGraph
import com.app.modular.ui.components.BottomSheetLayout
import com.app.modular.ui.theme.AndroidAppTemplateTheme
import com.app.ui.LocalSnackBarHostState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AndroidAppTemplateTheme {
                val navController = rememberNavController()
                val snackBarHostState = remember { SnackbarHostState() }
                val globalState = rememberSaveable(saver = globalStateSaver) { GlobalState() }
                val navigationState = remember { NavigationState() }

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    CompositionLocalProvider(
                        LocalAppState provides globalState,
                        LocalSnackBarHostState provides snackBarHostState,
                        LocalNavigationState provides navigationState
                    ) {
                        AppNavGraph(
                            navController = navController,
                            modifier = Modifier.fillMaxSize()
                        )
                        BottomSheetLayout()
                    }
                }
            }
        }
    }
}
