/*
 * Created by tsnanh on 6/5/22, 5:12 PM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 6/5/22, 1:37 PM
 */

package dev.tsnanh.android.spotifyclone.feature.library.ui

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun Library() {
    Scaffold(
        modifier = Modifier.windowInsetsPadding(WindowInsets.statusBars)
    ) {
        Text(text = "Hello Library", modifier = Modifier.padding(it))
    }
}
