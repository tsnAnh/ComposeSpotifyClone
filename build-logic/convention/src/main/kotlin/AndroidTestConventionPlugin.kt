/*
 * Created by tsnanh on 6/4/22, 9:39 PM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 6/4/22, 9:39 PM
 */

import com.android.build.gradle.TestExtension
import dev.tsnanh.android.spotifyclone.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

class AndroidTestConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.test")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<TestExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = 32
            }
        }
    }

}
