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
include(":features:feature-c:impl")
include(":features:feature-c:api")
include(":features:feature-b:impl")
include(":features:feature-b:api")
include(":features:feature-a:impl")
include(":features:feature-a:api")
