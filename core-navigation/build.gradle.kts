/*
 * Created by tsnanh on 6/4/22, 10:32 PM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 6/4/22, 10:32 PM
 */

@Suppress("DSL_SCOPE_VIOLATION")
plugins {
    id("dev.tsnanh.android.library")
    id("dev.tsnanh.android.library.jacoco")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
    alias(libs.plugins.ksp)
    id("dev.tsnanh.spotless")
}

dependencies {
    api(libs.androidx.hilt.navigation.compose)
    api(libs.androidx.navigation.compose)

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
}
