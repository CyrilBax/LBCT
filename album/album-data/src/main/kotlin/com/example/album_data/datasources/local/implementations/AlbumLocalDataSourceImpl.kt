package com.example.album_data.datasources.local.implementations

import com.example.album_data.cache.AlbumDataBase
import com.example.album_data.cache.AlbumEntity
import com.example.album_data.datasources.local.AlbumLocalDataSource
import com.example.album_data.datasources.models.AlbumModel
import com.example.extensions.commons.Mapper
import javax.inject.Inject

class AlbumLocalDataSourceImpl @Inject constructor(
    private val dataBase: AlbumDataBase,
    private val entityMapper: Mapper<List<AlbumModel>, List<AlbumEntity>>,
    private val cacheMapper: Mapper<List<AlbumEntity>, List<AlbumModel>>
) : AlbumLocalDataSource {

    override suspend fun getAlbumList(page: Int): List<AlbumModel> {
        return cacheMapper.mapTo(dataBase.albumDao.getAlbumPage(page))
    }

    override suspend fun saveAlbumList(albumList: List<AlbumModel>) {
        dataBase.albumDao.saveAll(entityMapper.mapTo(albumList))
    }
}