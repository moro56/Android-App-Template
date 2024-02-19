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

ktlint {
    android.set(true)
    outputColorName.set("RED")
}

dependencies {
    // Core
    implementation(libs.core.ktx)
    // App Startup
    implementation(libs.app.startup)

    implementation(project(":features:feature-a:impl"))
    implementation(project(":features:feature-b:impl"))
    implementation(project(":features:feature-c:api"))
    implementation(project(":features:feature-c:impl"))
    implementation(project(":features:feature-x:api"))
    implementation(project(":features:feature-x:impl"))
    implementation(project(":features:feature-y:api"))
    implementation(project(":features:feature-y:impl"))
    implementation(project(":features:feature-z:api"))
    implementation(project(":features:feature-z:impl"))
    implementation(project(":features:main:impl"))
    implementation(project(":ui"))
}
