package dev.tsnanh.android.core.ui.components

import androidx.compose.material.ripple.LocalRippleTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import dev.tsnanh.android.core.ui.ClearRippleTheme

@Composable
fun Rippleless(content: @Composable () -> Unit) {
    CompositionLocalProvider(LocalRippleTheme provides ClearRippleTheme) {
        content()
    }
}
