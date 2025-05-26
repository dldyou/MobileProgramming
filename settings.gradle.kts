pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
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

rootProject.name = "MobileProgrammingUI"
include(":app")
include(":eweek04a")
include(":eweek05a")
include(":assignment2")
include(":eweek06a")
include(":eweek07a")
include(":week09")
include(":week10")
include(":week11")
include(":week12")
