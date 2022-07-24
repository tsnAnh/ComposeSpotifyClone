/*
 * Created by tsnanh on 6/3/22, 11:29 PM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 6/3/22, 11:26 PM
 */

plugins {
    id("dev.tsnanh.android.library")
    id("dev.tsnanh.android.library.jacoco")
    kotlin("kapt")
    id("dev.tsnanh.spotless")
}

dependencies {
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    testImplementation(project(":core-testing"))
}
