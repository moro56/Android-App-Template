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
    // Core
    implementation(libs.core.ktx)

    implementation(project(":features:main:api"))
    implementation(project(":features:feature-x:impl"))
    implementation(project(":features:feature-y:impl"))
    implementation(project(":features:feature-c:impl"))
    implementation(project(":features:feature-z:impl"))
    implementation(project(":ui"))
}
