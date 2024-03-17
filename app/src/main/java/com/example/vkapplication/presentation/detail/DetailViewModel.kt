package com.example.vkapplication.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.room.Room
import com.example.vkapplication.data.Site
import com.example.vkapplication.data.SiteDao
import com.example.vkapplication.data.SiteDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class DetailViewModel(private val siteDao: SiteDao) : ViewModel() {

    fun getState(siteId: Int): StateFlow<DetailScreenState> =
        if (siteId == 0) {
            MutableStateFlow(DetailScreenState.Success(Site()))
        } else {
            siteDao.getSiteById(siteId)
                .flowOn(Dispatchers.IO)
                .map { DetailScreenState.Success(it!!) }
                .stateIn(
                    scope = viewModelScope,
                    started = SharingStarted.Eagerly,
                    initialValue = DetailScreenState.Loading
                )
        }

    fun handleUserAction(action: DetailScreenUserAction) {
        when(action) {
            is DetailScreenUserAction.Update -> viewModelScope.launch {
                withContext(Dispatchers.IO) { siteDao.insertSite(action.site) }
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val database = Room.databaseBuilder(
                    this[APPLICATION_KEY]!!,
                    SiteDataBase::class.java,
                    "site_database",
                ).build()
                DetailViewModel(database.siteDao)
            }
        }
    }
}
