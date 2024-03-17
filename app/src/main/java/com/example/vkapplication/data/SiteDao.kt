package com.example.vkapplication.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface SiteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSite(site: Site)

    @Delete
    fun deleteSite(site: Site)
    @Query("SELECT * FROM site")
    fun getSites(): Flow<List<Site>>

    @Query("SELECT * FROM site WHERE id = :siteId")
    fun getSiteById(siteId: Int): Flow<Site?> // Изменение типа возвращаемого значения на Flow<Sites?>
}
