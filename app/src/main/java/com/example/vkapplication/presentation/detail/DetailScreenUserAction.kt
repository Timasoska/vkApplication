package com.example.vkapplication.presentation.detail

import com.example.vkapplication.data.Site

sealed class DetailScreenUserAction {

    data class Update(val site: Site) : DetailScreenUserAction()
}
