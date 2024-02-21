plugins {
    alias(libs.plugins.androidLibrary)
    alias(libs.plugins.kotlinAndroid)
    id("compose-plugin")
    id("module-plugin")
    id("core-plugin")
    id("hilt-plugin")
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
