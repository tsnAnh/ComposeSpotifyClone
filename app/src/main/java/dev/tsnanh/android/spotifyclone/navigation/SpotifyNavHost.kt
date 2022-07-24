/*
 * Created by tsnanh on 6/5/22, 10:50 AM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 6/5/22, 10:50 AM
 */

package dev.tsnanh.android.spotifyclone.navigation

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import dev.tsnanh.android.spotifyclone.feature.home.navigation.HomeNavigation
import dev.tsnanh.android.spotifyclone.feature.home.navigation.home
import dev.tsnanh.android.spotifyclone.feature.library.navigation.library
import dev.tsnanh.android.spotifyclone.feature.search.navigation.search

@Composable
fun SpotifyNavHost(
    windowSizeClass: WindowSizeClass,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = HomeNavigation.route,
) {
    NavHost(navController = navController, startDestination = startDestination, modifier = modifier) {
        home()
        search()
        library()
    }
}
