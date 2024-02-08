@file:Suppress("UnstableApiUsage")

package com.app.gradle

import com.android.build.api.dsl.ApplicationExtension
import com.android.build.gradle.LibraryExtension
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.DependencyHandlerScope
import org.gradle.kotlin.dsl.dependencies
import org.gradle.kotlin.dsl.findByType
import org.gradle.kotlin.dsl.project

class CorePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            if (hasProperty("android")) {
                extensions.findByType<LibraryExtension>()?.apply {
                    dependencies {
                        addDependencies()
                    }
                }
                extensions.findByType<ApplicationExtension>()?.apply {
                    dependencies {
                        addDependencies()
                    }
                }
            }
        }
    }

    private fun DependencyHandlerScope.addDependencies() {
        this.apply {
            add("implementation", project(":core:base"))
            add("implementation", project(":core:mvi"))
            add("implementation", project(":core:navigation"))
            add("testImplementation", project(":core:test"))
            add("androidTestImplementation", project(":core:test"))
        }
    }
}
