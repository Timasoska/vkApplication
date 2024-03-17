package com.example.vkapplication.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(
    entities = [Site::class],
    version = 1,
    exportSchema = false,
)
abstract class SiteDataBase: RoomDatabase() {
    abstract val siteDao: SiteDao
}