package dev.tsnanh.android.spotifyclone.feature.home.models

import dev.tsnanh.android.spotifyclone.feature.home.SpotifyData

data class HomeUiState(
    val recentlyListenPlaylists: List<RecentlyListenPlaylistUiModel> = SpotifyData.MockRecentlyListenPlaylist,
    val favoriteArtists: List<ArtistUiModel> = emptyList(),
)
