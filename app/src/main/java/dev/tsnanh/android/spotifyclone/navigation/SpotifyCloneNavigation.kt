package dev.tsnanh.android.spotifyclone.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.tsnanh.android.spotifyclone.LocalAppState
import dev.tsnanh.android.spotifyclone.ui.home.Home
import dev.tsnanh.android.spotifyclone.ui.library.Library
import dev.tsnanh.android.spotifyclone.ui.search.Search

@Composable
fun SpotifyCloneNavigation(modifier: Modifier = Modifier) {
    val appState = LocalAppState.current
    NavHost(
        navController = appState.navController,
        startDestination = SpotifyCloneDestination.Home.route,
        modifier = modifier
    ) {
        composable(SpotifyCloneDestination.Home.route) {
            Home()
        }
        composable(SpotifyCloneDestination.Search.route) {
            Search()
        }
        composable(SpotifyCloneDestination.Library.route) {
            Library()
        }
    }
}
