package com.example.vkapplication.presentation.main

import com.example.vkapplication.data.Site

sealed class MainScreenState {

    data object Loading : MainScreenState()
    data class Success(val sites: List<Site>) : MainScreenState()
}
