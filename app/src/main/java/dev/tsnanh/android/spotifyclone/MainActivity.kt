package dev.tsnanh.android.spotifyclone

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import androidx.core.view.WindowCompat
import com.google.accompanist.insets.ProvideWindowInsets
import dev.tsnanh.android.spotifyclone.navigation.SpotifyCloneNavigation
import dev.tsnanh.android.spotifyclone.theme.SpotifyCloneTheme
import dev.tsnanh.android.spotifyclone.ui.main.Main

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            SpotifyCloneTheme {
                val appState = rememberAppState()
                CompositionLocalProvider(
                    LocalAppState providesDefault appState
                ) {
                    Main()
                }
            }
        }
    }
}
