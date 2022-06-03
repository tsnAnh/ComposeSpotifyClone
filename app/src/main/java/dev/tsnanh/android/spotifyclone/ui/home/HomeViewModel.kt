package dev.tsnanh.android.spotifyclone.ui.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.tsnanh.android.spotifyclone.SpotifyData
import dev.tsnanh.android.spotifyclone.common.UiConstants
import dev.tsnanh.android.spotifyclone.ui.home.models.ArtistUiModel
import dev.tsnanh.android.spotifyclone.ui.home.models.HomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    private val _homeUiState = MutableStateFlow(InitialState)
    val homeViewState = _homeUiState.asStateFlow()

    companion object {
        private val InitialState = HomeUiState(
            recentlyListenPlaylists = SpotifyData.MockRecentlyListenPlaylist.take(
                UiConstants.Playlist.NumberOfRecentPlaylistShowCount
            ),
            favoriteArtists = SpotifyData.MockRecentlyListenPlaylist.map {
                ArtistUiModel(
                    image = it.image,
                    title = it.playlistName
                )
            }
        )
    }
}
