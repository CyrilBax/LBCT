package com.example.album_domain.repositories

import com.example.album_data.datasources.models.AlbumModel

interface AlbumRepository {
    suspend fun getAlbumList(page: Int): List<AlbumModel>
}