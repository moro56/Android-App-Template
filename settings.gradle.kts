@file:Suppress("UnstableApiUsage")

pluginManagement {
    includeBuild("plugins")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Android-App-Template"
include(":app")
include(":core:base")
include(":core:mvi")
include(":core:navigation")
include(":core:test")
include(":features:feature-a")
include(":features:feature-b")
include(":features:feature-c")
include(":features:feature-x")
include(":features:feature-y")
include(":features:feature-z")
include(":features:main")
include(":ui")
