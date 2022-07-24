/*
 * Created by tsnanh on 6/5/22, 5:08 PM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 6/5/22, 5:08 PM
 */

package dev.tsnanh.android.spotifyclone.feature.library.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import dev.tsnanh.android.core.navigation.SpotifyNavigationDestination
import dev.tsnanh.android.spotifyclone.feature.library.ui.Library

object LibraryNavigation : SpotifyNavigationDestination {
    override val route: String = "library_route"
    override val destination: String = "library_destination"
}

fun NavGraphBuilder.library() {
    composable(LibraryNavigation.route) {
        Library()
    }
}
