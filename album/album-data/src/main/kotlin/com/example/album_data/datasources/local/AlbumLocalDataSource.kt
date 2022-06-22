package com.example.album_data.datasources.local

import com.example.album_data.datasources.models.AlbumModel

interface AlbumLocalDataSource {
    suspend fun getAlbumList(page: Int): List<AlbumModel>

    suspend fun saveAlbumList(albumList: List<AlbumModel>)
}