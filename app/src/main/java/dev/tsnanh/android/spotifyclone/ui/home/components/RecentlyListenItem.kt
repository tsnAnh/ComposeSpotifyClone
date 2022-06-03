package dev.tsnanh.android.spotifyclone.ui.home.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.tsnanh.android.spotifyclone.SpotifyData
import dev.tsnanh.android.spotifyclone.theme.SpotifyCloneColors
import dev.tsnanh.android.spotifyclone.ui.home.models.RecentlyListenPlaylistUiModel
import dev.tsnanh.android.spotifyclone.utils.extensions.alphaScaleClickable

@Composable
fun RecentlyListenItem(
    recentlyListenPlaylist: RecentlyListenPlaylistUiModel,
    onClick: (playlist: RecentlyListenPlaylistUiModel) -> Unit,
    modifier: Modifier = Modifier
) {
    val scaleFactor = .985F
    val alpha = .8F
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .alphaScaleClickable(
                onClick = {
                    onClick(recentlyListenPlaylist)
                },
                pressedScale = scaleFactor,
                pressedAlpha = alpha,
            )
            .clip(MaterialTheme.shapes.medium)
            .background(SpotifyCloneColors.White.copy(alpha = .2F))
            .padding(end = 8.dp),
    ) {
        AsyncImage(
            model = recentlyListenPlaylist.image,
            contentDescription = recentlyListenPlaylist.title,
            modifier = Modifier.size(56.dp),
            contentScale = ContentScale.Crop,
        )
        Text(
            text = recentlyListenPlaylist.title,
            style = MaterialTheme.typography.h4,
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .padding(bottom = 2.dp),
        )
    }
}

@Preview
@Composable
fun RecentlyListenPlaylistItemPreview() {
    RecentlyListenItem(recentlyListenPlaylist = SpotifyData.MockRecentlyListenPlaylist.first(), onClick = {})
}
