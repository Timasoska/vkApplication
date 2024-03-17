package com.example.vkapplication.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "site")
data class Site(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val websiteUrl: String = "",
    val title: String = "",
    var login: String = "",
    val password: String = "",
)
