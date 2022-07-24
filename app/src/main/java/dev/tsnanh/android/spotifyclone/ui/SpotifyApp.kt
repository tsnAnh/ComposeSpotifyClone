/*
 * Created by tsnanh on 6/5/22, 11:20 AM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 6/5/22, 11:20 AM
 */

package dev.tsnanh.android.spotifyclone.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import dev.tsnanh.android.core.ui.UiConstants
import dev.tsnanh.android.core.ui.components.Rippleless
import dev.tsnanh.android.core.ui.components.SpotifyCloneButtonPressEffect
import dev.tsnanh.android.core.ui.extensions.string
import dev.tsnanh.android.spotifyclone.navigation.SpotifyNavHost
import dev.tsnanh.android.spotifyclone.navigation.SpotifyTopLevelDestination
import dev.tsnanh.android.spotifyclone.navigation.SpotifyTopLevelNavigation
import dev.tsnanh.android.spotifyclone.navigation.TopLevelDestinations
import dev.tsnanh.android.spotifyclone.theme.SpotifyCloneTheme

@Composable
fun SpotifyApp(windowSizeClass: WindowSizeClass) {
    SpotifyCloneTheme {
        val navController = rememberNavController()
        val spotifyTopLevelNavigation = remember(navController) {
            SpotifyTopLevelNavigation(navController)
        }
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        Scaffold(
            bottomBar = {
                if (windowSizeClass.widthSizeClass == WindowWidthSizeClass.Compact) {
                    BottomBar(
                        onNavigateToTopLevelDestination = spotifyTopLevelNavigation::navigateTo,
                        currentDestination = currentDestination
                    )
                }
            },
        ) { padding ->
            SpotifyNavHost(
                windowSizeClass = windowSizeClass,
                navController = navController,
                modifier = Modifier.padding(top = padding.calculateTopPadding())
            )
            BottomNavigationScrim()
        }
    }
}

@Composable
fun BottomNavigationScrim() {
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

@Composable
fun BottomBar(
    onNavigateToTopLevelDestination: (SpotifyTopLevelDestination) -> Unit,
    currentDestination: NavDestination?,
) {
    Rippleless {
        BottomNavigation(
            backgroundColor = Color.Transparent,
            modifier = Modifier
                .windowInsetsPadding(
                    WindowInsets.safeDrawing.only(
                        WindowInsetsSides.Horizontal + WindowInsetsSides.Bottom,
                    )
                )
                .padding(horizontal = 32.dp),
            contentColor = Color.Transparent,
            elevation = 0.dp,
        ) {
            TopLevelDestinations.forEach { destination ->
                NavigationItem(
                    destination,
                    currentDestination,
                    onNavigateToTopLevelDestination
                )
            }
        }
    }
}

@Composable
private fun RowScope.NavigationItem(
    destination: SpotifyTopLevelDestination,
    currentDestination: NavDestination?,
    onNavigateToTopLevelDestination: (SpotifyTopLevelDestination) -> Unit,
) {
    SpotifyCloneButtonPressEffect { interactionSource, isPressed ->
        val color = getContentColor(destination, currentDestination, isPressed)
        val scale = if (isPressed) UiConstants.PressedScale else 1F
        val isSelected =
            currentDestination?.hierarchy?.any { it.route == destination.route } == true
        BottomNavigationItem(
            selected = isSelected,
            onClick = {
                onNavigateToTopLevelDestination(destination)
            },
            icon = {
                Icon(
                    imageVector = if (isSelected) {
                        destination.selectedIcon
                    } else {
                        destination.unselectedIcon
                    },
                    contentDescription = destination.textId.string,
                    tint = color,
                    modifier = Modifier.size(size = 30.dp)
                )
            },
            label = {
                Text(
                    text = destination.textId.string,
                    color = color,
                    fontSize = 10.sp,
                    fontWeight = FontWeight.Light,
                )
            },
            interactionSource = interactionSource,
            modifier = Modifier.scale(scale),
        )
    }
}

private fun getContentColor(
    destination: SpotifyTopLevelDestination,
    currentDestination: NavDestination?,
    isPressed: Boolean
) = if (destination.route == currentDestination?.route && !isPressed) {
    Color.White
} else {
    Color.White.copy(alpha = if (isPressed) UiConstants.PressedAlpha else UiConstants.ReleaseAlpha)
}
