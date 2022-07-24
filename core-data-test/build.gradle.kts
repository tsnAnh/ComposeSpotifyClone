/*
 * Created by tsnanh on 6/4/22, 10:29 PM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 6/4/22, 10:29 PM
 */

plugins {
    id("dev.tsnanh.android.library")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    id("dev.tsnanh.spotless")
}

dependencies {
    api(project(":core-data"))
    implementation(project(":core-testing"))

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    kaptAndroidTest(libs.hilt.compiler)
}
