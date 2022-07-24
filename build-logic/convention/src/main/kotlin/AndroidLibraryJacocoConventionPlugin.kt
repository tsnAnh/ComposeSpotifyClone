/*
 * Created by tsnanh on 6/4/22, 9:38 PM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 6/4/22, 9:38 PM
 */

import com.android.build.api.variant.LibraryAndroidComponentsExtension
import dev.tsnanh.android.spotifyclone.configureJacoco
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

class AndroidLibraryJacocoConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            with(pluginManager) {
                apply("org.gradle.jacoco")
                apply("com.android.library")
            }
            val extension = extensions.getByType<LibraryAndroidComponentsExtension>()
            configureJacoco(extension)
        }
    }

}
