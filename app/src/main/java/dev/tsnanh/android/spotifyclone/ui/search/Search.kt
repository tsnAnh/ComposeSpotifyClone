package dev.tsnanh.android.spotifyclone.ui.search

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.google.accompanist.insets.ui.Scaffold
import dev.tsnanh.android.spotifyclone.common.LocalAppState

@Composable
fun Search() {
    val appState = LocalAppState.current
    Scaffold(
        scaffoldState = appState.scaffoldState,
        contentPadding = WindowInsets.statusBars.asPaddingValues()
    ) {
        Text(text = "Hello Search", modifier = Modifier.padding(it))
    }
}
