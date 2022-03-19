package dev.tsnanh.android.spotifyclone.ui.home

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.google.accompanist.insets.ui.Scaffold
import dev.tsnanh.android.spotifyclone.LocalAppState

@Composable
fun Home() {
    val appState = LocalAppState.current
    Scaffold(
        scaffoldState = appState.scaffoldState,
        contentPadding = WindowInsets.statusBars.asPaddingValues()
    ) {
        Text(text = "Hello Spotify Clone", modifier = Modifier.padding(it), color = Color.Black)
    }
}
