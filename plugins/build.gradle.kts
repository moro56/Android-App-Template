plugins {
    `kotlin-dsl`
}

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

dependencies {
    compileOnly(libs.gradle.tools)
    compileOnly(libs.kotlin.gradle.plugin)
}

gradlePlugin {
    plugins {
        register("module-plugin") {
            id = "module-plugin"
            implementationClass = "com.app.gradle.ModulePlugin"
        }
        register("compose-plugin") {
            id = "compose-plugin"
            implementationClass = "com.app.gradle.ComposePlugin"
        }
        register("core-plugin") {
            id = "core-plugin"
            implementationClass = "com.app.gradle.CorePlugin"
        }
        register("hilt-plugin") {
            id = "hilt-plugin"
            implementationClass = "com.app.gradle.HiltPlugin"
        }
    }
}
