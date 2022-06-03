package dev.tsnanh.android.spotifyclone.ui.home.models

import dev.tsnanh.android.spotifyclone.common.models.HomeListItemUiModel

data class ArtistUiModel(
    override val image: String,
    override val title: String,
    override val subtitle: String? = null,
) : HomeListItemUiModel {
    val artistName by ::title
}
