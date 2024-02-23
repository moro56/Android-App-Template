plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    id("plugin.feature")
    id("plugin.library.compose")
    id("plugin.hilt")
}

android {
    namespace = "com.app.main.impl"
}

hilt {
    enableAggregatingTask = true
}

dependencies {
    implementation(project(":features:feature-x"))
    implementation(project(":features:feature-y"))
    implementation(project(":features:feature-c"))
    implementation(project(":features:feature-z"))
    implementation(project(":ui"))
}
