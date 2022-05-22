package dev.tsnanh.android.spotifyclone.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import dev.tsnanh.android.spotifyclone.common.AppState
import dev.tsnanh.android.spotifyclone.common.LocalAppState
import dev.tsnanh.android.spotifyclone.common.UiConstants
import dev.tsnanh.android.spotifyclone.common.composables.Rippleless
import dev.tsnanh.android.spotifyclone.common.composables.SpotifyCloneButtonPressEffect
import dev.tsnanh.android.spotifyclone.navigation.SpotifyCloneBottomNavigationDestinations
import dev.tsnanh.android.spotifyclone.navigation.SpotifyCloneNavigation
import dev.tsnanh.android.spotifyclone.utils.extensions.string

@Composable
fun Main() {
    val appState = LocalAppState.current
    Scaffold(
        scaffoldState = appState.scaffoldState,
        bottomBar = {
            MainBottomNavigation(appState = appState)
        }
    ) {
        SpotifyCloneNavigation()
        Box(modifier = Modifier.fillMaxSize()) {
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .fillMaxWidth()
                    .fillMaxHeight(fraction = 0.3F)
                    .background(
                        brush = Brush.verticalGradient(
                            listOf(
                                Color.Transparent,
                                Color.Black.copy(alpha = .1F),
                                Color.Black.copy(alpha = .2F),
                                Color.Black.copy(alpha = .3F),
                                Color.Black.copy(alpha = .4F),
                                Color.Black.copy(alpha = .5F),
                                Color.Black
                            )
                        )
                    )
            )
        }
    }
}

@Composable
fun MainBottomNavigation(appState: AppState) {
    if (appState.shouldShowBottomBar) {
        val navBackStackEntry by appState.navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination
        Rippleless {
            com.google.accompanist.insets.ui.BottomNavigation(
                modifier = Modifier
                    .navigationBarsPadding()
                    .offset(y = 6.dp)
                    .padding(horizontal = 24.dp),
                elevation = 0.dp,
                backgroundColor = Color.Transparent,
                contentColor = Color.White,
            ) {
                appState.bottomBarTabs.forEach { destination ->
                    MainBottomNavigationItem(destination, currentDestination, appState)
                }
            }
        }
    }
}

@Composable
private fun RowScope.MainBottomNavigationItem(
    destination: SpotifyCloneBottomNavigationDestinations,
    currentDestination: NavDestination?,
    appState: AppState
) {
    SpotifyCloneButtonPressEffect { interactionSource, isPressed ->
        val color = getContentColor(destination, currentDestination, isPressed)
        val scale = if (isPressed) UiConstants.PressedScale else 1F
        val isSelected =
            currentDestination?.hierarchy?.any { it.route == destination.route } == true
        BottomNavigationItem(
            selected = isSelected,
            onClick = {
                appState.navigateToBottomBarRoute(destination.route)
            },
            icon = {
                Icon(
                    painter = painterResource(
                        id = if (isSelected) {
                            destination.selectedIcon
                        } else {
                            destination.unselectedIcon
                        }
                    ),
                    contentDescription = destination.titleRes.string,
                    tint = color,
                    modifier = Modifier.size(size = 30.dp)
                )
            },
            label = {
                Text(
                    text = destination.titleRes.string,
                    color = color,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Light,
                )
            },
            interactionSource = interactionSource,
            modifier = Modifier.scale(scale)
        )
    }
}

private fun getContentColor(
    destination: SpotifyCloneBottomNavigationDestinations,
    currentDestination: NavDestination?,
    isPressed: Boolean
) = if (destination.route == currentDestination?.route && !isPressed) {
    Color.White
} else {
    Color.White.copy(alpha = if (isPressed) UiConstants.PressedAlpha else UiConstants.ReleaseAlpha)
}
