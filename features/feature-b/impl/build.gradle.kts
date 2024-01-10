plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    id("compose-plugin")
    id("module-plugin")
    id("hilt-plugin")
}

android {
    namespace = "com.app.featureb.impl"
}

hilt {
    enableAggregatingTask = true
}

dependencies {
    // Core
    implementation(libs.core.ktx)

    implementation(project(":features:feature-b:api"))
}
