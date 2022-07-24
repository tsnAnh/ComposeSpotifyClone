/*
 * Created by tsnanh on 6/4/22, 10:59 PM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 6/4/22, 10:59 PM
 */

plugins {
    id("dev.tsnanh.android.library")
    id("dev.tsnanh.android.feature")
    id("dev.tsnanh.android.library.compose")
    id("dagger.hilt.android.plugin")
    id("dev.tsnanh.spotless")
}

dependencies {
    implementation(libs.androidx.palette)
}
