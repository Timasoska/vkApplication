package com.example.vkapplication.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
@Dao
interface Dao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSite(site: Sites)

    @Delete
    suspend fun deleteSite(site: Sites)
    @Query("SELECT * FROM site")
    suspend fun getSites(): Flow<List<Sites>>

}