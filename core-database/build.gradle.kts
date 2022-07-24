/*
 * Created by tsnanh on 6/4/22, 10:03 PM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 6/4/22, 10:03 PM
 */

// TODO: Remove once https://youtrack.jetbrains.com/issue/KTIJ-19369 is fixed
@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("dev.tsnanh.android.library")
    id("dev.tsnanh.android.library.jacoco")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    alias(libs.plugins.ksp)
    id("dev.tsnanh.spotless")
}

android {
    defaultConfig {
        // The schemas directory contains a schema file for each version of the Room database.
        // This is required to enable Room auto migrations.
        // See https://developer.android.com/reference/kotlin/androidx/room/AutoMigration.
        ksp {
            arg("room.schemaLocation", "$projectDir/schemas")
        }

        testInstrumentationRunner = "dev.tsnanh.android.core.testing.SpotifyCloneTestRunner"
    }
}

dependencies {
    implementation(project(":core-model"))

    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)

    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.datetime)

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    androidTestImplementation(project(":core-testing"))
}
