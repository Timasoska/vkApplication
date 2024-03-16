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
    fun insertSite(site: Sites)

    @Delete
    fun deleteSite(site: Sites)
    @Query("SELECT * FROM site")
    fun getSites(): Flow<List<Sites>>

    @Query("SELECT * FROM site WHERE id = :siteId")
    fun getSiteById(siteId: Int): Flow<Sites?> // Изменение типа возвращаемого значения на Flow<Sites?>

}