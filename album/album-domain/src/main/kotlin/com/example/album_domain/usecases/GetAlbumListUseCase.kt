package com.example.album_domain.usecases

import com.example.album_data.datasources.models.AlbumModel

interface GetAlbumListUseCase {

    suspend fun execute(page: Int): List<AlbumModel>
}