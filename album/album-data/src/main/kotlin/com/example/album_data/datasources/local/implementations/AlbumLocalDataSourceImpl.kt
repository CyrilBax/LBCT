package com.example.album_data.datasources.local.implementations

import com.example.album_data.cache.AlbumDAO
import com.example.album_data.cache.AlbumDataBase
import com.example.album_data.cache.AlbumEntity
import com.example.album_data.datasources.local.AlbumLocalDataSource
import com.example.album_data.datasources.models.AlbumModel
import com.example.extensions.commons.Mapper
import javax.inject.Inject

class AlbumLocalDataSourceImpl @Inject constructor(
    dataBase: AlbumDataBase,
    private val entityMapper: Mapper<List<AlbumModel>, List<AlbumEntity>>,
    private val cacheMapper: Mapper<List<AlbumEntity>, List<AlbumModel>>
) : AlbumLocalDataSource {

    private var albumDAO: AlbumDAO = dataBase.getAlbumDao()

    override suspend fun getAlbumList(page: Int): List<AlbumModel> {
        return cacheMapper.mapTo(albumDAO.getAlbumPage(page))
    }

    override suspend fun saveAlbumList(albumList: List<AlbumModel>) {
        albumDAO.saveAll(entityMapper.mapTo(albumList))
    }
}