/*
 * Created by tsnanh on 6/4/22, 11:04 PM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 6/4/22, 11:03 PM
 */

plugins {
    id("dev.tsnanh.android.application")
    id("dev.tsnanh.android.application.compose")
    id("dev.tsnanh.android.application.jacoco")
    kotlin("kapt")
    id("jacoco")
    id("dagger.hilt.android.plugin")
    id("dev.tsnanh.spotless")
}

android {
    namespace = "dev.tsnanh.android.spotifyclone"
    defaultConfig {
        applicationId = "dev.tsnanh.android.spotifyclone"
        versionCode = 1
        versionName = "0.0.1" // X.Y.Z; X = Major, Y = minor, Z = Patch level

        // Custom test runner to set up Hilt dependency graph
        testInstrumentationRunner =
            "com.google.samples.apps.nowinandroid.core.testing.NiaTestRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        val debug by getting {
            applicationIdSuffix = ".debug"
        }
        val release by getting {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
        val benchmark by creating {
            initWith(release)
            signingConfig = signingConfigs.getByName("debug")
            matchingFallbacks.add("release")
            proguardFiles("benchmark-rules.pro")
        }
        val staging by creating {
            initWith(debug)
            signingConfig = signingConfigs.getByName("debug")
            matchingFallbacks.add("debug")
            applicationIdSuffix = ".staging"
        }
    }
    packagingOptions {
        resources {
            excludes.add("/META-INF/{AL2.0,LGPL2.1}")
        }
    }
    testOptions {
        unitTests {
            isIncludeAndroidResources = true
        }
    }
}

dependencies {
    implementation(project(":feature-home"))
    implementation(project(":feature-search"))
    implementation(project(":feature-library"))

    implementation(project(":core-ui"))
    implementation(project(":core-navigation"))

    androidTestImplementation(project(":core-testing"))
    androidTestImplementation(project(":core-datastore-test"))
    androidTestImplementation(project(":core-data-test"))
    androidTestImplementation(project(":core-network"))

    implementation(libs.androidx.activity.compose)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.core.splashscreen)
    implementation(libs.androidx.compose.material3.windowSizeClass)
    implementation(libs.androidx.window.manager)
    implementation(libs.androidx.compose.material)
    implementation(libs.material3)
    implementation(libs.androidx.profileinstaller)

    implementation(libs.coil.kt)
    implementation(libs.coil.kt.svg)

    implementation(libs.hilt.android)
    kapt(libs.hilt.compiler)
    kaptAndroidTest(libs.hilt.compiler)

    // androidx.test is forcing JUnit, 4.12. This forces it to use 4.13
    configurations.configureEach {
        resolutionStrategy {
            force(libs.junit4)
            // Temporary workaround for https://issuetracker.google.com/174733673
            force("org.objenesis:objenesis:2.6")
        }
    }
}
