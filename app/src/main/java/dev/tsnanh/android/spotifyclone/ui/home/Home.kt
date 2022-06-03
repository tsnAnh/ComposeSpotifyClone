package dev.tsnanh.android.spotifyclone.ui.home

import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.palette.graphics.Palette
import com.google.accompanist.insets.ui.Scaffold
import dev.tsnanh.android.spotifyclone.R
import dev.tsnanh.android.spotifyclone.common.AppState
import dev.tsnanh.android.spotifyclone.common.LocalAppState
import dev.tsnanh.android.spotifyclone.common.UiConstants
import dev.tsnanh.android.spotifyclone.common.composables.Rippleless
import dev.tsnanh.android.spotifyclone.common.composables.SpotifyCloneButtonPressEffect
import dev.tsnanh.android.spotifyclone.common.composables.SpotifyListItem
import dev.tsnanh.android.spotifyclone.ui.home.components.RecentlyListenItem
import dev.tsnanh.android.spotifyclone.ui.home.models.HomeToolbarActions
import dev.tsnanh.android.spotifyclone.ui.home.models.HomeUiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.withContext
import java.net.URL

@Composable
fun Home() {
    val appState = LocalAppState.current
    val viewModel: HomeViewModel = hiltViewModel()
    val homeViewState by viewModel.homeViewState.collectAsState()
    HomeContent(appState, homeViewState)
}

@Composable
private fun HomeContent(appState: AppState, homeUiState: HomeUiState) {
    Scaffold(
        scaffoldState = appState.scaffoldState,
        contentPadding = WindowInsets.statusBars.asPaddingValues(),
    ) {
        Box {
            val homeListState = rememberLazyListState()
            var firstItemHeight by remember {
                mutableStateOf(1F)
            }
            GradientScrim(homeUiState, homeListState, firstItemHeight)
            LazyColumn(
                contentPadding = PaddingValues(
                    bottom = 72.dp,
                    top = it.calculateTopPadding()
                ),
                state = homeListState,
                modifier = Modifier
            ) {
                item {
                    Column(
                        modifier = Modifier
                            .onSizeChanged { firstItemHeight = it.height.toFloat() }
                    ) {
                        HomeTopBar()
                        HomeRecentlyListenPlaylists(homeUiState = homeUiState)
                    }
                }
                item { HomeFavoriteArtistList(homeUiState = homeUiState) }
                item { HomeFavoriteArtistList(homeUiState = homeUiState) }
                item { HomeFavoriteArtistList(homeUiState = homeUiState) }
                item { HomeFavoriteArtistList(homeUiState = homeUiState) }
            }
        }
    }
}

@Composable
private fun GradientScrim(
    homeUiState: HomeUiState,
    homeListState: LazyListState,
    firstItemHeight: Float,
) {
    val firstRecentlyListenItemImage =
        homeUiState.recentlyListenPlaylists.firstNotNullOf { it.image }
    var gradientScrimColor by remember {
        mutableStateOf(Color.Transparent)
    }
    var gradientScrimAlpha by remember {
        mutableStateOf(1F)
    }
    val isFirstVisibleItemIndex by remember {
        derivedStateOf { homeListState.firstVisibleItemIndex == 0 }
    }
    LaunchedEffect(firstRecentlyListenItemImage) {
        coroutineScope {
            val palette = getPaletteColor(firstRecentlyListenItemImage)
            withContext(Dispatchers.Main) {
                gradientScrimColor =
                    Color(palette.getLightMutedColor(android.graphics.Color.TRANSPARENT))
            }
        }
    }
    LaunchedEffect(
        homeListState.firstVisibleItemScrollOffset,
        firstItemHeight,
    ) {
        val value = if (isFirstVisibleItemIndex) {
            homeListState.firstVisibleItemScrollOffset.toFloat() / firstItemHeight
        } else {
            1F
        }
        val alpha = getScrimAlpha(
            isFirstVisibleItemIndex,
            value
        )
        gradientScrimAlpha = alpha
    }
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(240.dp)
            .background(
                brush = Brush.radialGradient(
                    listOf(
                        gradientScrimColor.copy(alpha = .7F),
                        Color.Transparent,
                        Color.Transparent,
                    ),
                    radius = 2000F,
                    center = Offset(160F, -360F)
                ), alpha = gradientScrimAlpha
            )
    )
}

private fun getScrimAlpha(isFirstItemVisible: Boolean, value: Float) =
    if (isFirstItemVisible) {
        1 - value.coerceAtMost(1F)
    } else {
        0F
    }

private suspend fun getPaletteColor(firstRecentlyListenItemImage: String): Palette {
    return withContext(Dispatchers.IO) {
        val bitmap = BitmapFactory.decodeStream(
            @Suppress("BlockingMethodInNonBlockingContext")
            URL(firstRecentlyListenItemImage).openConnection().getInputStream()
        )
        val scaledBitmap = Bitmap.createScaledBitmap(bitmap, 100, 100, false)
        Palette.from(scaledBitmap).generate()
    }
}

@Composable
private fun HomeTopBar() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
            .padding(top = 36.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.Top
    ) {
        Title(title = stringResource(R.string.text_goodEvening))
        Rippleless {
            Row {
                HomeToolbarActions.All.forEach { action ->
                    HomeActionButton(action) {}
                }
            }
        }
    }
}

@Composable
private fun Title(title: String, modifier: Modifier = Modifier) {
    Text(
        text = title,
        style = MaterialTheme.typography.h2,
        modifier = modifier.padding(top = 8.dp, start = 4.dp)
    )
}

@Composable
private fun HomeActionButton(action: HomeToolbarActions, onClick: () -> Unit) {
    SpotifyCloneButtonPressEffect { interactionSource, isPressed ->
        val tintColor =
            if (isPressed) {
                Color.White.copy(
                    alpha = if (isPressed) {
                        UiConstants.PressedAlpha
                    } else {
                        UiConstants.ReleaseAlpha
                    }
                )
            } else {
                Color.White
            }
        val scale = if (isPressed) UiConstants.PressedScale else 1F
        IconButton(
            onClick = onClick,
            interactionSource = interactionSource,
            modifier = Modifier
                .scale(scale)
                .padding(bottom = 4.dp)
        ) {
            Icon(
                imageVector = action.icon,
                contentDescription = action.contentDescription,
                tint = tintColor,
                modifier = Modifier.size(size = 28.dp)
            )
        }
    }
}

@Composable
private fun HomeRecentlyListenPlaylists(homeUiState: HomeUiState) {
    val playlistsChunked =
        homeUiState.recentlyListenPlaylists.chunked(UiConstants.Playlist.RecentlyListenPlaylistItemPerRow)
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp)
    ) {
        playlistsChunked.forEach { playlists ->
            Spacer(modifier = Modifier.height(4.dp))
            Row {
                playlists.forEach { playlist ->
                    Spacer(modifier = Modifier.width(4.dp))
                    RecentlyListenItem(playlist, modifier = Modifier.weight(1F), onClick = {})
                    Spacer(modifier = Modifier.width(4.dp))
                }
            }
            Spacer(modifier = Modifier.height(4.dp))
        }
    }
}

@Composable
private fun HomeFavoriteArtistList(homeUiState: HomeUiState) {
    Column {
        Title(
            title = stringResource(R.string.text_yourFavoriteArtist),
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .padding(bottom = 4.dp)
        )
        LazyRow(modifier = Modifier.padding(horizontal = 8.dp)) {
            items(homeUiState.favoriteArtists) { favoriteArtist ->
                SpotifyListItem(item = favoriteArtist, onClick = {}, imageSize = 156.dp)
            }
        }
    }
}

@Preview
@Composable
fun HomeTopBarPreview() {
    HomeTopBar()
}

@Preview
@Composable
fun HomePreview() {
    HomeContent(LocalAppState.current, HomeUiState())
}
