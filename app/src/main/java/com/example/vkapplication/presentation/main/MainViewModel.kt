package com.example.vkapplication.presentation.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.room.Room
import com.example.vkapplication.data.SiteDao
import com.example.vkapplication.data.SiteDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainViewModel(private val siteDao: SiteDao) : ViewModel() {

    fun getState(): StateFlow<MainScreenState> = siteDao.getSites()
        .flowOn(Dispatchers.IO)
        .map { MainScreenState.Success(it) }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.Eagerly,
            initialValue = MainScreenState.Loading
        )

    fun handleUserAction(action: MainScreenUserAction) {
        when (action) {
            is MainScreenUserAction.Delete -> viewModelScope.launch {
                withContext(Dispatchers.IO) { siteDao.deleteSite(action.site) }
            }
        }
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val database = Room.databaseBuilder(
                    this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]!!,
                    SiteDataBase::class.java,
                    "site_database",
                ).build()
                MainViewModel(database.siteDao)
            }
        }
    }
}
