package dev.tsnanh.android.spotifyclone.ui.library

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.insets.ui.Scaffold
import dev.tsnanh.android.spotifyclone.LocalAppState

@Composable
fun Library() {
    val appState = LocalAppState.current
    Scaffold(
        scaffoldState = appState.scaffoldState,
        contentPadding = WindowInsets.statusBars.asPaddingValues()
    ) {
        Text(text = "Hello Library", modifier = Modifier.padding(it))
    }
}
