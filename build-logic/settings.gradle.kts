/*
 * Created by tsnanh on 6/3/22, 11:29 PM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 6/3/22, 11:26 PM
 */

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
    }
    versionCatalogs {
        create("libs") {
            from(files("../gradle/libs.versions.toml"))
        }
    }
}

include(":convention")
