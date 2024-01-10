plugins {
    alias(libs.plugins.androidApplication)
    alias(libs.plugins.kotlinAndroid)
    id("module-plugin")
    id("compose-plugin")
    id("core-plugin")
    id("hilt-plugin")
}

android {
    namespace = "com.app.modular"

    defaultConfig {
        applicationId = "com.app.modular"
        versionCode = 1
        versionName = "1.0.0"

        vectorDrawables {
            useSupportLibrary = true
        }
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {
    // Core
    implementation(libs.core.ktx)

    implementation(project(":features:feature-a:api"))
    implementation(project(":features:feature-a:impl"))
    implementation(project(":features:feature-b:api"))
    implementation(project(":features:feature-b:impl"))
    implementation(project(":features:feature-c:api"))
    implementation(project(":features:feature-c:impl"))

    implementation(libs.lifecycle.runtime.ktx)
    implementation(libs.ui.tooling.preview)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.test.ext.junit)
    androidTestImplementation(libs.espresso.core)
    androidTestImplementation(libs.ui.test.junit4)
    debugImplementation(libs.ui.test.manifest)
}