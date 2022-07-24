/*
 * Created by tsnanh on 6/5/22, 10:36 AM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 6/5/22, 10:36 AM
 */

package dev.tsnanh.android.spotifyclone.navigation

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LibraryMusic
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.LibraryMusic
import androidx.compose.material.icons.outlined.Search
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController
import dev.tsnanh.android.spotifyclone.R
import dev.tsnanh.android.spotifyclone.feature.home.navigation.HomeNavigation
import dev.tsnanh.android.spotifyclone.feature.library.navigation.LibraryNavigation
import dev.tsnanh.android.spotifyclone.feature.search.navigation.SearchNavigation

class SpotifyTopLevelNavigation(private val navController: NavHostController) {
    fun navigateTo(destination: SpotifyTopLevelDestination) {
        navController.navigate(destination.route) {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navController.graph.findStartDestination().id) {
                saveState = true
            }
            // Avoid multiple copies of the same destination when
            // reselecting the same item
            launchSingleTop = true
            // Restore state when reselecting a previously selected item
            restoreState = true
        }
    }
}

data class SpotifyTopLevelDestination(
    val route: String,
    val selectedIcon: ImageVector,
    val unselectedIcon: ImageVector,
    val textId: Int,
)

val TopLevelDestinations = listOf(
    SpotifyTopLevelDestination(
        route = HomeNavigation.route,
        textId = R.string.text_home,
        selectedIcon = Icons.Filled.Home,
        unselectedIcon = Icons.Outlined.Home,
    ),
    SpotifyTopLevelDestination(
        route = SearchNavigation.route,
        textId = R.string.text_search,
        selectedIcon = Icons.Filled.Search,
        unselectedIcon = Icons.Outlined.Search,
    ),
    SpotifyTopLevelDestination(
        route = LibraryNavigation.route,
        textId = R.string.text_library,
        selectedIcon = Icons.Filled.LibraryMusic,
        unselectedIcon = Icons.Outlined.LibraryMusic,
    ),
)
