@file:Suppress("UnstableApiUsage")

package com.app.gradle

import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.api.artifacts.VersionCatalogsExtension
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.getByType
import org.gradle.kotlin.dsl.project

class TestPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val libs = extensions.getByType<VersionCatalogsExtension>().named("libs")

            dependencies {
                val test = libs.findBundle("test").get()
                val androidTest = libs.findBundle("android-test").get()
                add("implementation", project(":core:test"))
                add("testImplementation", test)
                add("androidTestImplementation", androidTest)
            }
        }
    }
}
