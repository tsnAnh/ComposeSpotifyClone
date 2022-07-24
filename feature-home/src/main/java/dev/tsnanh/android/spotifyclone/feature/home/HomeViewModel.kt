/*
 * Created by tsnanh on 6/5/22, 11:00 AM
 * Copyright (c) 2022 . All rights reserved.
 * Last modified 6/3/22, 10:40 PM
 */

package dev.tsnanh.android.spotifyclone.feature.home

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.tsnanh.android.spotifyclone.feature.home.models.HomeUiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor() : ViewModel() {
    private val _homeUiState = MutableStateFlow(HomeUiState())
    val homeUiState = _homeUiState.asStateFlow()
}
