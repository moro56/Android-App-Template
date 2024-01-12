plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    id("compose-plugin")
    id("module-plugin")
    id("core-plugin")
    id("hilt-plugin")
}

android {
    namespace = "com.app.featurec.impl"
}

hilt {
    enableAggregatingTask = true
}

dependencies {
    // Core
    implementation(libs.core.ktx)

    implementation(project(":features:feature-c:api"))
}
