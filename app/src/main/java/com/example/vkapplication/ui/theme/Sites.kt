package com.example.vkapplication.ui.theme

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "site")
data class Sites(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val imageUrl: String,
    val title: String,
    val login: String,
    val password: String
)
