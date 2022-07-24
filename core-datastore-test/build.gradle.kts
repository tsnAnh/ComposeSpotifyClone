/*
 * Created by tsnanh on 6/4/22, 10:46 PM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 6/4/22, 10:46 PM
 */

plugins {
    id("dev.tsnanh.android.library")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("dev.tsnanh.spotless")
}

dependencies {
    api(project(":core-datastore"))
    implementation(project(":core-testing"))

    api(libs.androidx.dataStore.core)

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    kaptAndroidTest(libs.hilt.compiler)
}
