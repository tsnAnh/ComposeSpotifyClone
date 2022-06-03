package dev.tsnanh.android.spotifyclone.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import dev.tsnanh.android.spotifyclone.common.LocalAppState
import dev.tsnanh.android.spotifyclone.ui.home.Home
import dev.tsnanh.android.spotifyclone.ui.library.Library
import dev.tsnanh.android.spotifyclone.ui.search.Search

@Composable
fun SpotifyCloneNavigation(modifier: Modifier = Modifier) {
    val appState = LocalAppState.current
    NavHost(
        navController = appState.navController,
        startDestination = SpotifyCloneBottomNavigationDestinations.Home.route,
        modifier = modifier
    ) {
        composable(SpotifyCloneBottomNavigationDestinations.Home.route) {
            Home()
        }
        composable(SpotifyCloneBottomNavigationDestinations.Search.route) {
            Search()
        }
        composable(SpotifyCloneBottomNavigationDestinations.Library.route) {
            Library()
        }
    }
}
