plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    id("plugin.library")
    id("plugin.library.compose")
}

android {
    namespace = "com.app.core.mvi"
}

dependencies {
    testImplementation(project(":core:test"))
}
