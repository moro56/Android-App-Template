plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    id("compose-plugin")
    id("module-plugin")
    id("hilt-plugin")
}

android {
    namespace = "com.app.core.navigation"
}
