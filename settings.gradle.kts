@file:Suppress("UnstableApiUsage")

include(":feature-library")


include(":feature-search")


include(":startup")


include(":feature-home")


include(":core-ui")


include(":core-network")


include(":core-datastore-test")


include(":core-datastore")


include(":core-navigation")


include(":core-data-test")

/*
* Created by tsnanh on 6/3/22, 11:29 PM
* Copyright (c) 2022 . All rights reserved.
* Last modified 6/3/22, 11:27 PM
*/

pluginManagement {
    includeBuild("build-logic")
    repositories {
        gradlePluginPortal()
        google()
        mavenCentral()
    }
    resolutionStrategy {
        eachPlugin {
            if( requested.id.id == "dagger.hilt.android.plugin") {
                useModule("com.google.dagger:hilt-android-gradle-plugin:2.39.1")
            }
        }
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "spotify-clone"
include(":app")
include(":core-common")
include(":core-model")
include(":core-testing")
include(":core-data")
include(":core-database")
