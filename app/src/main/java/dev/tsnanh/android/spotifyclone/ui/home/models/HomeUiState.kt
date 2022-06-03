package dev.tsnanh.android.spotifyclone.ui.home.models

data class HomeUiState(
    val recentlyListenPlaylists: List<RecentlyListenPlaylistUiModel> = emptyList(),
    val favoriteArtists: List<ArtistUiModel> = emptyList(),
)
