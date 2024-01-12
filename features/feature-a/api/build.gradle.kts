plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    id("compose-plugin")
    id("module-plugin")
}

android {
    namespace = "com.app.featurea.api"
}

dependencies {
    implementation(project(":core:navigation"))
}
