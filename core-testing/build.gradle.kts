/*
 * Created by tsnanh on 6/4/22, 9:50 PM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 6/4/22, 9:50 PM
 */

plugins {
    id("dev.tsnanh.android.library")
    kotlin("kapt")
    id("dev.tsnanh.spotless")
}

dependencies {
    implementation(project(":core-common"))
    implementation(project(":core-data"))
    implementation(project(":core-model"))

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)

    api(libs.junit4)
    api(libs.androidx.test.core)
    api(libs.kotlinx.coroutines.test)

    api(libs.androidx.test.espresso.core)
    api(libs.androidx.test.runner)
    api(libs.androidx.test.rules)
    api(libs.androidx.compose.ui.test)
    api(libs.hilt.android.testing)

    debugApi(libs.androidx.compose.ui.testManifest)
}
