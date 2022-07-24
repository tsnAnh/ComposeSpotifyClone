package dev.tsnanh.android.spotifyclone.feature.home.models

data class ArtistUiModel(
    override val image: String,
    override val title: String,
    override val subtitle: String? = null,
) : HomeListItemUiModel {
    val artistName by ::title
}
