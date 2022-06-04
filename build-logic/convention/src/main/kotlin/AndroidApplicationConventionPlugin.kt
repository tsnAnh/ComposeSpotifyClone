import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import dev.tsnanh.android.spotifyclone.configureKotlinAndroid
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.configure

/*
 * Created by tsnanh on 6/3/22, 11:39 PM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 6/3/22, 11:39 PM
 */

class AndroidApplicationConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("com.android.application")
                apply("org.jetbrains.kotlin.android")
            }

            extensions.configure<BaseAppModuleExtension> {
                configureKotlinAndroid(this)
                defaultConfig.targetSdk = 32
            }
        }
    }
}
