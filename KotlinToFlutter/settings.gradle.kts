pluginManagement {
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

        // Add the new repositories starting on the next line...
        maven {
            setUrl("../flutter_module/build/host/outputs/repo")
            // This is relative to the location of the build.gradle file
            // if using a relative path.
        }
        maven {
            setUrl("https://storage.googleapis.com/download.flutter.io")
        }
    }
}

rootProject.name = "KotlinToFlutter"
include(":app")
 