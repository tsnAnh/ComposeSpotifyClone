package dev.tsnanh.android.spotifyclone.composables

import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import dev.tsnanh.android.spotifyclone.utils.ClearRippleTheme

@Composable
fun Rippleless(content: @Composable () -> Unit) {
    CompositionLocalProvider(LocalRippleTheme provides ClearRippleTheme) {
        content()
    }
}
