@file:Suppress("UnstableApiUsage")

include(":core:test")


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
include(":features:feature-y:impl")
include(":features:feature-y:api")
include(":features:feature-x:impl")
include(":features:feature-x:api")
include(":features:feature-z:impl")
include(":features:feature-z:api")
include(":features:main:impl")
include(":features:main:api")
include(":ui")
