/*
 * Created by tsnanh on 6/4/22, 9:52 PM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 6/4/22, 9:52 PM
 */

plugins {
    id("dev.tsnanh.android.library")
    id("dev.tsnanh.android.library.jacoco")
    kotlin("kapt")
    id("kotlinx-serialization")
    id("dagger.hilt.android.plugin")
    id("dev.tsnanh.spotless")
}

dependencies {
    implementation(project(":core-common"))
    implementation(project(":core-model"))
    implementation(project(":core-database"))
    implementation(project(":core-datastore"))
    // implementation(project(":core-network"))

    testImplementation(project(":core-testing"))
    testImplementation(project(":core-datastore-test"))

    implementation(libs.kotlinx.datetime)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.kotlinx.serialization.json)

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
}
