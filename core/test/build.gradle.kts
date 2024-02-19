plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    id("module-plugin")
}

android {
    namespace = "com.app.core.test"
}

dependencies {
    compileOnly(libs.bundles.test)
}
