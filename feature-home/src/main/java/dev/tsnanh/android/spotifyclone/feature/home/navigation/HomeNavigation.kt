/*
 * Created by tsnanh on 6/5/22, 10:58 AM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 6/5/22, 10:58 AM
 */

package dev.tsnanh.android.spotifyclone.feature.home.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import dev.tsnanh.android.core.navigation.SpotifyNavigationDestination
import dev.tsnanh.android.spotifyclone.feature.home.Home

object HomeNavigation : SpotifyNavigationDestination {
    override val route: String = "home_route"
    override val destination: String = "home_destination"
}

fun NavGraphBuilder.home() {
    composable(route = HomeNavigation.route) {
        Home()
    }
}
