package com.example.album_data.services

import com.example.album_data.services.models.AlbumRemoteModel

interface AlbumService {

    suspend fun getAlbumList(page: Int): List<AlbumRemoteModel>
}