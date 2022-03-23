package dev.tsnanh.android.spotifyclone

import android.graphics.Color
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.CompositionLocalProvider
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.WindowCompat
import dev.tsnanh.android.spotifyclone.theme.SpotifyCloneTheme
import dev.tsnanh.android.spotifyclone.ui.main.Main

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        installSplashScreen()
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        window.navigationBarColor = Color.BLACK
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
