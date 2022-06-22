package com.example.album_data.services.models


data class AlbumRemoteModel(
    val albumId: Int,
    val id: Int,
    val title: String,
    val url: String,
    val thumbnailUrl: String
)