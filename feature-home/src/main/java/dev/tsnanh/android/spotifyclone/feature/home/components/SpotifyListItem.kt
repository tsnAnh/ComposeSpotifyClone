/*
 * Created by tsnanh on 6/5/22, 12:09 PM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 6/5/22, 11:03 AM
 */

package dev.tsnanh.android.spotifyclone.feature.home.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import dev.tsnanh.android.core.ui.UiConstants
import dev.tsnanh.android.core.ui.extensions.alphaScaleClickable
import dev.tsnanh.android.spotifyclone.feature.home.models.HomeListItemUiModel

@Composable
fun <T : HomeListItemUiModel> SpotifyListItem(
    item: T,
    onClick: (model: T) -> Unit,
    modifier: Modifier = Modifier,
    subtitle: (@Composable (item: T) -> Unit)? = null,
    imageSize: Dp = UiConstants.Artist.DefaultArtistImageSize.dp,
    horizontalAlignment: Alignment.Horizontal = Alignment.CenterHorizontally,
    imageShape: Shape = CircleShape,
) {
    Column(
        horizontalAlignment = horizontalAlignment,
        modifier = modifier
            .padding(8.dp)
            .alphaScaleClickable { onClick(item) }) {
        AsyncImage(
            model = item.image,
            contentDescription = item.title,
            modifier = Modifier
                .size(imageSize)
                .clip(imageShape),
            contentScale = ContentScale.Crop,
        )
        Spacer(modifier = Modifier.height(8.dp))
        item.title?.let {
            Text(text = it, style = MaterialTheme.typography.h3)
        }
        subtitle?.let {
            if (item.title != null) {
                Spacer(modifier = Modifier.height(4.dp))
            }
            subtitle(item)
        }
    }
}

@Preview
@Composable
fun FavoriteArtistItemPreview() {
    // SpotifyListItem(
    //     artist = UiModel(
    //         image = "https://www.oregonlive.com/resizer/MT6RnFZNKtgMLoUZVJk1xqcAF3M=/1280x0/smart/cloudfront-us-east-1.images.arcpublishing.com/advancelocal/O2PTXVD4YVDRPFLYZMAYWBJ3DE.png",
    //         artistName = "Encanto"
    //     ),
    //     onClick = {}
    // )
}
