package dev.tsnanh.android.spotifyclone.ui.home.models

import dev.tsnanh.android.spotifyclone.common.models.HomeListItemUiModel

data class RecentlyListenPlaylistUiModel(
    override val title: String,
    override val subtitle: String? = null,
    override val image: String,
) : HomeListItemUiModel {
    val playlistName by ::title
}
