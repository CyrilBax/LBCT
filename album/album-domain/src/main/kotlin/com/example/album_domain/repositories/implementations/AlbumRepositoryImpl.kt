package com.example.album_domain.repositories.implementations

import com.example.album_data.datasources.local.AlbumLocalDataSource
import com.example.album_data.datasources.models.AlbumModel
import com.example.album_data.datasources.remote.AlbumRemoteDataSource
import com.example.album_domain.repositories.AlbumRepository
import javax.inject.Inject

class AlbumRepositoryImpl @Inject constructor(
    private val local: AlbumLocalDataSource,
    private val remote: AlbumRemoteDataSource
) : AlbumRepository {

    override suspend fun getAlbumList(page: Int): List<AlbumModel> {
        return try {
            val albumList = local.getAlbumList(page)
            if (albumList.isNullOrEmpty() && remote.isOnline()) {
                val remoteList = remote.getAlbumList(page)
                local.saveAlbumList(remoteList)
                local.getAlbumList(page)
            } else {
                albumList
            }
        } catch (e: Exception) {
            // todo return sealed class with error message to show
            emptyList()
        }
    }
}