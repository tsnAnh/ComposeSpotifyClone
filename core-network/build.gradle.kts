/*
 * Created by tsnanh on 6/4/22, 10:48 PM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 6/4/22, 10:48 PM
 */

plugins {
    id("dev.tsnanh.android.library")
    id("dev.tsnanh.android.library.jacoco")
    kotlin("kapt")
    id("kotlinx-serialization")
    id("dagger.hilt.android.plugin")
    id("dev.tsnanh.spotless")
    id("com.google.android.libraries.mapsplatform.secrets-gradle-plugin")
}

android {
    buildTypes {
        val staging by creating {
            initWith(getByName("debug"))
            matchingFallbacks.add("debug")
        }
    }
    // Force the staging variant to use the release source directory. This is necessary so that the
    // staging variant uses the remote network.
    sourceSets {
        getByName("staging") {
            java.srcDir("src/release/java")
        }
    }
}

secrets {
    defaultPropertiesFileName = "secrets.defaults.properties"
}

dependencies {
    implementation(project(":core-common"))
    implementation(project(":core-model"))

    testImplementation(project(":core-testing"))

    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.serialization.json)
    implementation(libs.kotlinx.datetime)

    implementation(libs.okhttp.logging)
    implementation(libs.retrofit.core)
    implementation(libs.retrofit.kotlin.serialization)

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
}
