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
        google()
        maven ("https://jitpack.io" )
        mavenCentral()
        maven ( "https://maven.aliyun.com/repository/public" )
        maven (  "https://repo1.maven.org/maven2/")
        mavenLocal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
        google()
        maven ("https://jitpack.io" )
        mavenCentral()
        maven ( "https://maven.aliyun.com/repository/public" )
        maven (  "https://repo1.maven.org/maven2/")
        mavenLocal()
    }
}

rootProject.name = "RichDemoProject"
include(":app",":richeditor")
include(":mylibrary")
