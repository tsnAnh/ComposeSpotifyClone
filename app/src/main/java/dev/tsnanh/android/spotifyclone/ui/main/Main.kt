package dev.tsnanh.android.spotifyclone.ui.main

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import dev.tsnanh.android.spotifyclone.AppState
import dev.tsnanh.android.spotifyclone.LocalAppState
import dev.tsnanh.android.spotifyclone.navigation.SpotifyCloneNavigation

@Composable
fun Main() {
    val appState = LocalAppState.current
    Scaffold(
        scaffoldState = appState.scaffoldState,
        bottomBar = {
            MainBottomNavigation(appState = appState)
        }
    ) { innerPadding ->
        SpotifyCloneNavigation(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
fun MainBottomNavigation(appState: AppState) {
    com.google.accompanist.insets.ui.BottomNavigation(
        contentPadding = WindowInsets.navigationBars.asPaddingValues()
    ) {
        val navBackStackEntry by appState.navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        appState.bottomBarTabs.forEach { destination ->
            BottomNavigationItem(
                selected = currentDestination?.hierarchy?.any { it.route == destination.route } == true,
                onClick = {
                    appState.navigateToBottomBarRoute(destination.route)
                },
                icon = { Icon(imageVector = Icons.Filled.Favorite, contentDescription = null) },
                label = { Text(text = destination.route) }
            )
        }
    }
}
