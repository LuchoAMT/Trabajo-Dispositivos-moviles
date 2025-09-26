package com.calyrsoft.ucbp1.features.movie.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "movies")
data class MovieEntity (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val title: String,
    val pathUrl: String?
)