package dev.tsnanh.android.spotifyclone

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import dagger.hilt.android.AndroidEntryPoint
import dev.tsnanh.android.spotifyclone.common.LocalAppState
import dev.tsnanh.android.spotifyclone.common.rememberAppState
import dev.tsnanh.android.spotifyclone.theme.SpotifyCloneTheme
import dev.tsnanh.android.spotifyclone.ui.main.Main

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.navigationBarColor = Color.TRANSPARENT
        setContent {
            SpotifyCloneTheme {
                val appState = rememberAppState()
                CompositionLocalProvider(
                    LocalAppState provides appState
                ) {
                    Main()
                }
            }
        }
    }
}
