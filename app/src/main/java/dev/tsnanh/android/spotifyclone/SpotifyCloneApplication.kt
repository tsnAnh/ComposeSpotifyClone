/*
 * Created by tsnanh on 6/4/22, 11:10 PM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 6/3/22, 10:40 PM
 */

package dev.tsnanh.android.spotifyclone

import android.app.Application
import coil.ImageLoader
import coil.ImageLoaderFactory
import coil.decode.SvgDecoder
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SpotifyCloneApplication : Application(), ImageLoaderFactory {
    override fun newImageLoader(): ImageLoader {
        return ImageLoader.Builder(this)
            .components {
                add((SvgDecoder.Factory()))
            }
            .build()
    }
}
