package dev.tsnanh.android.spotifyclone.feature.home.models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.History
import androidx.compose.material.icons.rounded.NotificationsNone
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.ui.graphics.vector.ImageVector

sealed class HomeToolbarActions(val icon: ImageVector, val contentDescription: String? = null) {
    object Notifications : HomeToolbarActions(icon = Icons.Rounded.NotificationsNone)
    object Recently : HomeToolbarActions(icon = Icons.Rounded.History)
    object Settings : HomeToolbarActions(icon = Icons.Rounded.Settings)

    companion object {
        val All = listOf(Notifications, Recently, Settings)
    }
}
