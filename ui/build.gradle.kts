plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    id("compose-plugin")
    id("module-plugin")
    id("core-plugin")
}

android {
    namespace = "com.app.ui"
}

dependencies {
    // Core
    implementation(libs.core.ktx)
}
