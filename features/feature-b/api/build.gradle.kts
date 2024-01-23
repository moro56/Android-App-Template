plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    id("compose-plugin")
    id("module-plugin")
}

android {
    namespace = "com.app.featureb.api"
}

dependencies {
    implementation(project(":core:navigation"))
}
