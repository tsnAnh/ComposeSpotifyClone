/*
 * Created by tsnanh on 6/5/22, 2:05 PM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 6/5/22, 2:05 PM
 */

package dev.tsnanh.android.spotifyclone.feature.search.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import dev.tsnanh.android.core.navigation.SpotifyNavigationDestination
import dev.tsnanh.android.spotifyclone.feature.search.Search

object SearchNavigation : SpotifyNavigationDestination {
    override val route: String = "search_route"
    override val destination: String = "search_destination"
}

fun NavGraphBuilder.search() {
    composable(SearchNavigation.route) {
        Search()
    }
}
