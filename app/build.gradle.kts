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

    implementation(project(":features:feature-a"))
    implementation(project(":features:feature-b"))
    implementation(project(":features:feature-c"))
    implementation(project(":features:feature-x"))
    implementation(project(":features:feature-y"))
    implementation(project(":features:feature-z"))
    implementation(project(":features:main"))
    implementation(project(":ui"))
}
