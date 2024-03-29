@file:Suppress("UnstableApiUsage")

package com.app.gradle

import com.android.build.gradle.LibraryExtension
import com.app.gradle.configurations.composeConf
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class LibraryComposePlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            val extension = extensions.getByType<LibraryExtension>()
            composeConf(extension)
        }
    }
}
