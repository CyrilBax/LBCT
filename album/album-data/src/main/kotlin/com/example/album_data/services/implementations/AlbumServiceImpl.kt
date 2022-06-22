package com.example.album_data.services.implementations

import com.example.album_data.services.AlbumService
import com.example.album_data.services.Service
import com.example.album_data.services.models.AlbumRemoteModel
import javax.inject.Inject

class AlbumServiceImpl @Inject constructor(
    private val service: Service
) : AlbumService {
    override suspend fun getAlbumList(page: Int): List<AlbumRemoteModel> = service.getAlbumList()
}