package dev.tsnanh.android.spotifyclone.ui.main

import androidx.compose.foundation.background
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.compose.currentBackStackEntryAsState
import dev.tsnanh.android.spotifyclone.AppState
import dev.tsnanh.android.spotifyclone.LocalAppState
import dev.tsnanh.android.spotifyclone.composables.Rippleless
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
    ) { innerPadding ->
        SpotifyCloneNavigation(modifier = Modifier.padding(innerPadding))
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
                                Color.Black.copy(alpha = .4F),
                                Color.Black.copy(alpha = .7F),
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
    val interactions = remember { mutableStateListOf<Interaction>() }
    val interactionSource = remember {
        MutableInteractionSource()
    }
    val isPressed = interactions.any { it is PressInteraction.Press }
    val color = getContentColor(destination, currentDestination, isPressed)
    val scale = if (isPressed) 0.9F else 1F
    val isSelected = currentDestination?.hierarchy?.any { it.route == destination.route } == true
    LaunchedEffect(interactionSource) {
        interactionSource.interactions.collect { interaction ->
            when (interaction) {
                is PressInteraction.Press -> interactions.add(interaction)
                is PressInteraction.Release -> interactions.remove(interaction.press)
                is PressInteraction.Cancel -> interactions.remove(interaction.press)
                is DragInteraction.Start -> interactions.add(interaction)
                is DragInteraction.Stop -> interactions.remove(interaction.start)
                is DragInteraction.Cancel -> interactions.remove(interaction.start)
            }
        }
    }
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
                tint = color
            )
        },
        label = { Text(text = destination.titleRes.string, color = color) },
        interactionSource = interactionSource,
        modifier = Modifier.scale(scale)
    )
}

private fun getContentColor(
    destination: SpotifyCloneBottomNavigationDestinations,
    currentDestination: NavDestination?,
    isPressed: Boolean
) = if (destination.route == currentDestination?.route && !isPressed) {
    Color.White
} else {
    Color.White.copy(alpha = if (isPressed) .3F else .5F)
}
