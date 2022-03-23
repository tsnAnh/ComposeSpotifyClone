package dev.tsnanh.android.spotifyclone.navigation

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.navigation.NavArgument
import dev.tsnanh.android.spotifyclone.R

sealed class SpotifyCloneBottomNavigationDestinations(
    val route: String,
    @StringRes val titleRes: Int,
    @DrawableRes val selectedIcon: Int,
    @DrawableRes val unselectedIcon: Int,
    val arguments: List<NavArgument> = emptyList()
) {
    object Home :
        SpotifyCloneBottomNavigationDestinations(
            route = SpotifyCloneRoutes.HomeRoute, titleRes = R.string.text_home,
            selectedIcon = R.drawable.ic_round_home,
            unselectedIcon = R.drawable.ic_outline_home
        )

    object Search : SpotifyCloneBottomNavigationDestinations(
        route = SpotifyCloneRoutes.SearchRoute,
        titleRes = R.string.text_search,
        selectedIcon = R.drawable.ic_round_search,
        unselectedIcon = R.drawable.ic_round_search,
    )

    object Library : SpotifyCloneBottomNavigationDestinations(
        route = SpotifyCloneRoutes.LibraryRoute,
        titleRes = R.string.text_library,
        selectedIcon = R.drawable.ic_round_library_music,
        unselectedIcon = R.drawable.ic_outline_library_music,
    )

    companion object {
        val BottomNavigationDestinations = listOf(Home, Search, Library)
    }
}
