package com.example.vkapplication.presentation.main

import com.example.vkapplication.data.Site

sealed class MainScreenUserAction {

    data class Delete(val site: Site) : MainScreenUserAction()
}
