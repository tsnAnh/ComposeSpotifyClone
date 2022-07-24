package dev.tsnanh.android.spotifyclone.feature.home.models

data class RecentlyListenPlaylistUiModel(
    override val title: String,
    override val subtitle: String? = null,
    override val image: String,
) : HomeListItemUiModel {
    val playlistName by ::title
}
