package com.example.vkapplication.ui.theme

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

interface Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSite(site: Sites)

    @Delete
    suspend fun deleteSite(site: Sites)
    @Query("SELECT * FROM site")
    fun getSites(): Flow<List<Sites>>

}