package dev.tsnanh.android.spotifyclone

import androidx.compose.runtime.compositionLocalOf

val LocalAppState = compositionLocalOf<AppState> { throw IllegalStateException() }
