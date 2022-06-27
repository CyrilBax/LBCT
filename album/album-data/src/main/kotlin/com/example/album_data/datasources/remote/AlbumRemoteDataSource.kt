package com.example.album_data.datasources.remote

import com.example.album_data.datasources.models.AlbumModel

interface AlbumRemoteDataSource {
    suspend fun getAlbumList(): List<AlbumModel>

    suspend fun isOnline(): Boolean
}