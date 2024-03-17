package com.example.vkapplication.presentation.detail

import com.example.vkapplication.data.Site

sealed class DetailScreenState {

    data object Loading : DetailScreenState()

    data class Success(val site: Site) : DetailScreenState()
}