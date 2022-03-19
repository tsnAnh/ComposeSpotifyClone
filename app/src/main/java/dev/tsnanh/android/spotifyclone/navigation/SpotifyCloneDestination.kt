package dev.tsnanh.android.spotifyclone.navigation

import androidx.navigation.NavArgument

sealed class SpotifyCloneDestination(
    val route: String,
    val arguments: List<NavArgument> = emptyList()
) {
    object Home : SpotifyCloneDestination(route = SpotifyCloneRoutes.HomeRoute)
    object Search : SpotifyCloneDestination(route = SpotifyCloneRoutes.SearchRoute)
    object Library : SpotifyCloneDestination(route = SpotifyCloneRoutes.LibraryRoute)

    companion object {
        val BottomNavigationDestinations = listOf(Home, Search, Library)
    }
}
