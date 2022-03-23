package dev.tsnanh.android.spotifyclone.utils.extensions

import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import kotlin.contracts.ExperimentalContracts

@OptIn(ExperimentalContracts::class)
val @receiver:StringRes Int?.string: String
    @Composable get() = this?.let { stringResource(id = it) } ?: ""

@Composable
fun @receiver:StringRes Int?.string(vararg formatArgs: Any) =
    this?.let { stringResource(id = it, formatArgs = formatArgs) } ?: ""
