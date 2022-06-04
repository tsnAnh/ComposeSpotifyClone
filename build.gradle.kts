/*
 * Created by tsnanh on 6/3/22, 11:29 PM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 6/3/22, 11:27 PM
 */

// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()
        mavenCentral()
    }

    dependencies {
        classpath(libs.android.gradlePlugin)
        classpath(libs.kotlin.gradlePlugin)
        classpath(libs.kotlin.serializationPlugin)
        classpath(libs.hilt.gradlePlugin)
        classpath(libs.secrets.gradlePlugin)
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
