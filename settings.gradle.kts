rootDir
    .listFiles()
    ?.filter {
        it.isDirectory &&
            it.name != "build-logic" &&
            File(it, "build.gradle.kts").exists()
    }?.forEach { include(it.name) }

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
    }

    includeBuild("build-logic")
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)

    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
}
