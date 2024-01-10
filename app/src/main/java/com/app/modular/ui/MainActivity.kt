package com.app.modular.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.app.core.navigation.Navigator
import com.app.featurea.api.ModuleAApi
import com.app.featureb.api.ModuleBApi
import com.app.featurec.api.ModuleCApi
import com.app.modular.navigation.AppNavGraph
import com.app.modular.ui.theme.AndroidAppTemplateTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    lateinit var featureA: ModuleAApi

    @Inject
    lateinit var featureB: ModuleBApi

    @Inject
    lateinit var featureC: ModuleCApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Navigator
        Navigator.initialize(
            features = listOf(featureA, featureB, featureC),
            modalFeatures = listOf()
        )

        setContent {
            AndroidAppTemplateTheme {
                val navController = rememberNavController()

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavGraph(navController = navController, modifier = Modifier.fillMaxSize())
                }
            }
        }
    }
}
