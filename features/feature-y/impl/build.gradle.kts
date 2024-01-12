plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    id("compose-plugin")
    id("module-plugin")
    id("core-plugin")
    id("hilt-plugin")
}

android {
    namespace = "com.app.featurey.impl"
}

hilt {
    enableAggregatingTask = true
}

dependencies {
    // Core
    implementation(libs.core.ktx)

    implementation(project(":features:feature-y:api"))
    implementation(project(":features:feature-z:api"))
}
