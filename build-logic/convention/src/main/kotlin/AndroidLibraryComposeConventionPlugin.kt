import com.android.build.gradle.LibraryExtension
import dev.tsnanh.android.spotifyclone.configureAndroidCompose
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType

/*
 * Created by tsnanh on 6/4/22, 9:29 PM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 6/4/22, 9:29 PM
 */

class AndroidLibraryComposeConventionPlugin : Plugin<Project> {
    override fun apply(target: Project) {
        with(target) {
            pluginManager.apply("com.android.library")
            val extension = extensions.getByType<LibraryExtension>()
            configureAndroidCompose(extension)
        }
    }
}
