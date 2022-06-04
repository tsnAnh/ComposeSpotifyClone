/*
 * Created by tsnanh on 6/3/22, 11:42 PM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 6/3/22, 11:42 PM
 */

import com.android.build.api.variant.ApplicationAndroidComponentsExtension
import dev.tsnanh.android.spotifyclone.configureJacoco
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class AndroidApplicationJacocoConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.gradle.jacoco")
                apply("com.android.application")
            }
            val extension = extensions.getByType<ApplicationAndroidComponentsExtension>()
            configureJacoco(extension)
        }
    }

}
