package com.example.vkapplication.ui.theme

import androidx.room.Database
import androidx.room.RoomDatabase
@Database(
    entities = [Sites::class],
    version = 1
)
abstract class SiteDataBase: RoomDatabase() {
    abstract val dao: Dao
}