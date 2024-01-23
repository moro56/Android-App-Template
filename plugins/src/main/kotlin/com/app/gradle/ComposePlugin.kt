@file:Suppress("UnstableApiUsage")

package com.app.gradle

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalog
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.findByType
import org.gradle.kotlin.dsl.getByType

class ComposePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            if (hasProperty("android")) {
                val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

                extensions.findByType<LibraryExtension>()?.apply {
                    buildFeatures {
                        compose = true
                    }

                    composeOptions {
                        kotlinCompilerExtensionVersion =
                            libs.findVersion("compose-compiler").get().toString()
                    }

                    dependencies {
                        addDependencies(libs)
                    }
                }

                extensions.findByType<ApplicationExtension>()?.apply {
                    buildFeatures {
                        compose = true
                    }

                    composeOptions {
                        kotlinCompilerExtensionVersion =
                            libs.findVersion("compose-compiler").get().toString()
                    }

                    dependencies {
                        addDependencies(libs)
                    }
                }
            }
        }
    }

    private fun DependencyHandlerScope.addDependencies(libs: VersionCatalog) {
        this.apply {
            val bom = libs.findLibrary("compose-bom").get()
            val compose = libs.findBundle("compose").get()
            val composeTooling = libs.findLibrary("compose-ui-tooling").get()

            add("implementation", platform(bom))
            add("implementation", compose)
            add("debugImplementation", composeTooling)

            val test = libs.findBundle("test").get()
            val androidTest = libs.findBundle("android-test").get()
            val composeTest = libs.findLibrary("ui-test-junit4").get()
            val composeManifest = libs.findLibrary("ui-test-manifest").get()

            add("implementation", compose)
            add("testImplementation", test)
            add("testImplementation", platform(bom))
            add("testImplementation", composeTest)
            add("androidTestImplementation", androidTest)
            add("androidTestImplementation", platform(bom))
            add("androidTestImplementation", composeTest)
            add("debugImplementation", composeManifest)
        }
    }
}
