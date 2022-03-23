package dev.tsnanh.android.spotifyclone.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.runtime.Composable

private val DarkColorPalette = darkColors(
    primary = SpotifyCloneColors.Purple200,
    primaryVariant = SpotifyCloneColors.Purple700,
    secondary = SpotifyCloneColors.Teal200,
    surface = SpotifyCloneColors.Surface
)
@Composable
fun SpotifyCloneTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colors = DarkColorPalette,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}
