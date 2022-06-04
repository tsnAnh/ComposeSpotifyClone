/*
 * Created by tsnanh on 6/3/22, 11:37 PM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 6/3/22, 11:37 PM
 */

import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import dev.tsnanh.android.spotifyclone.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class AndroidApplicationComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.android.application")
            val extension = extensions.getByType<BaseAppModuleExtension>()
            configureAndroidCompose(extension)
        }
    }
}
