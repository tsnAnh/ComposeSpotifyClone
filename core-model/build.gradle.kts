@file:Suppress("UnstableApiUsage")

/*
* Created by tsnanh on 6/4/22, 9:13 PM
* Copyright (c) 2022 . All rights reserved.
* Last modified 6/4/22, 9:13 PM
*/

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("dev.tsnanh.android.library")
    id("dev.tsnanh.android.library.jacoco")
    id("kotlinx-serialization")
    alias(libs.plugins.ksp)
    id("dev.tsnanh.spotless")
}

dependencies {
    testImplementation(project(":core-testing"))

    implementation(libs.room.runtime)
    implementation(libs.room.ktx)
    ksp(libs.room.compiler)

    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.datetime)
    implementation(libs.kotlinx.serialization.json)
}
