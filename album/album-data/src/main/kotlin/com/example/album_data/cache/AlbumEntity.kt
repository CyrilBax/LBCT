package com.example.album_data.cache

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AlbumEntity(
    val albumId: Int,
    @PrimaryKey(autoGenerate = false)
    val id: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
)