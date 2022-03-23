package dev.tsnanh.android.spotifyclone

import android.content.res.Resources
import androidx.compose.material.ScaffoldState
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dev.tsnanh.android.spotifyclone.navigation.SpotifyCloneBottomNavigationDestinations
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class AppState(
    val scaffoldState: ScaffoldState,
    val navController: NavHostController,
    val coroutineScope: CoroutineScope,
    private val resources: Resources
) {
    val bottomBarTabs = SpotifyCloneBottomNavigationDestinations.BottomNavigationDestinations

    val shouldShowBottomBar: Boolean
        @Composable
        get() {
            val currentDestination by navController.currentBackStackEntryAsState()
            return currentDestination?.destination?.route in SpotifyCloneBottomNavigationDestinations.BottomNavigationDestinations.map { it.route }
        }

    fun navigateToBottomBarRoute(route: String) {
        navController.navigate(route = route) {
            restoreState = true
            launchSingleTop = true
        }
    }

    fun showSnackbar(
        message: String,
        actionLabel: String? = null,
        duration: SnackbarDuration = SnackbarDuration.Short
    ) {
        coroutineScope.launch {
            scaffoldState.snackbarHostState.showSnackbar(
                message = message,
                actionLabel = actionLabel,
                duration = duration
            )
        }
    }
}

@Composable
fun rememberAppState(
    scaffoldState: ScaffoldState = rememberScaffoldState(),
    navController: NavHostController = rememberNavController(),
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    resources: Resources = LocalContext.current.resources,
) = remember(scaffoldState, navController, coroutineScope, resources) {
    AppState(scaffoldState, navController, coroutineScope, resources)
}
