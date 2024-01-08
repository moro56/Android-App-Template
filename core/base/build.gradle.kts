plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    alias(libs.plugins.kotlinSerialization)
    id("compose-plugin")
    id("module-plugin")
}

android {
    namespace = "com.app.core.base"
}

dependencies {
    // Core
    implementation(libs.core.ktx)
    implementation(libs.bundles.lifecycle)
    // Json
    implementation(libs.serialization.json)
}
