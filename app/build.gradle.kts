plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    id("plugin.app")
    id("plugin.app.compose")
    id("plugin.hilt")
}

android {
    namespace = "com.app.modular"
}

ktlint {
    android.set(true)
    outputColorName.set("RED")
}

dependencies {
    implementation(project(":features:feature-a"))
    implementation(project(":features:feature-b"))
    implementation(project(":features:feature-c"))
    implementation(project(":features:feature-x"))
    implementation(project(":features:feature-y"))
    implementation(project(":features:feature-z"))
    implementation(project(":features:main"))
    implementation(project(":ui"))
}
