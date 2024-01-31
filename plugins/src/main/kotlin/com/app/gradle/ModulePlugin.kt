@file:Suppress("UnstableApiUsage")

package com.app.gradle

import com.android.build.gradle.AppExtension
import com.android.build.gradle.BaseExtension
import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure
import org.gradle.kotlin.dsl.findByType
import org.jetbrains.kotlin.gradle.plugin.KaptExtension
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

class ModulePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply {
                apply("kotlin-android")
                apply("kotlin-kapt")
                apply("org.jlleitschuh.gradle.ktlint")
            }

            configure<KaptExtension> {
                correctErrorTypes = true
            }

            if (hasProperty("android")) {
                extensions.configure<BaseExtension> {
                    compileSdkVersion(34)

                    defaultConfig {
                        minSdk = 26
                        targetSdk = 34

                        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
                    }

                    compileOptions {
                        sourceCompatibility = JavaVersion.VERSION_17
                        targetCompatibility = JavaVersion.VERSION_17
                    }

                    buildFeatures.buildConfig = true

                    project.tasks.withType(KotlinCompile::class.java).configureEach {
                        kotlinOptions {
                            jvmTarget = JavaVersion.VERSION_17.toString()
                            freeCompilerArgs = listOf(
                                "-Xstring-concat=inline",
                                "-Xlint:deprecation",
                                "-opt-in=androidx.compose.material3.ExperimentalMaterial3Api",
                                "-opt-in=kotlinx.coroutines.ExperimentalCoroutinesApi"
                            )
                        }
                    }

                    packagingOptions.setExcludes(
                        mutableSetOf(
                            "META-INF/**",
                            "LICENSE"
                        )
                    )

                    testOptions {
                        unitTests {
                            isIncludeAndroidResources = true
                            isReturnDefaultValues = true
                        }
                    }
                }
                extensions.findByType<LibraryExtension>()?.apply {
                    definesCommonSettings(this)
                }
                extensions.findByType<AppExtension>()?.apply {
                    definesCommonSettings(this)
                    productFlavors {
                        getByName("dev") {
                            applicationIdSuffix = ".dev"
                        }
                    }
                }
            }
        }
    }

    private fun definesCommonSettings(extension: BaseExtension) = with(extension) {
        defaultConfig {
            consumerProguardFile("consumer-rules.pro")
        }

        buildTypes {
            getByName("debug") {
                isDebuggable = true
            }
            getByName("release") {
                isDebuggable = false
                isMinifyEnabled = true
                proguardFiles(
                    getDefaultProguardFile("proguard-android-optimize.txt"),
                    "proguard-rules.pro"
                )
            }
        }

        flavorDimensions("version")
        productFlavors {
            create("dev") {
                dimension = "version"
            }
            create("prod") {
                dimension = "version"
            }
        }
    }
}