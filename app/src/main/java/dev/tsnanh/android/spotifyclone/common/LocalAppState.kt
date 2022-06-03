package dev.tsnanh.android.spotifyclone.common

import androidx.compose.runtime.compositionLocalOf

val LocalAppState = compositionLocalOf<AppState> { throw IllegalStateException() }
