package com.app.modular

import android.app.Application
import androidx.startup.AppInitializer
import com.app.modular.startup.NavigatorInitializer
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()

        // Initialize navigator
        AppInitializer.getInstance(this).initializeComponent(NavigatorInitializer::class.java)
    }
}
