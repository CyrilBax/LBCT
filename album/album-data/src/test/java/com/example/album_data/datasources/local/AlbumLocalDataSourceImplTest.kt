package com.example.album_data.datasources.local

import com.example.album_data.cache.AlbumDataBase
import com.example.album_data.cache.AlbumEntity
import com.example.album_data.datasources.local.implementations.AlbumLocalDataSourceImpl
import com.example.album_data.datasources.models.AlbumModel
import com.example.extensions.commons.Mapper
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class AlbumLocalDataSourceImplTest {

    private lateinit var localDataSource: AlbumLocalDataSourceImpl
    private var dataBase: AlbumDataBase = mock()
    private var entityMapper: Mapper<List<AlbumModel>, List<AlbumEntity>> = mock()
    private var cacheMapper: Mapper<List<AlbumEntity>, List<AlbumModel>> = mock()

    private val dataBaseResult: List<AlbumEntity> = mock()
    private val albumToSaveMockedData: List<AlbumModel> = mock()
    private val cacheMapperResult: List<AlbumModel> = mock()
    private val entityMapperResult: List<AlbumEntity> = mock()

    private val page = 1

    @Before
    fun setup() {
        runBlocking {
            localDataSource = AlbumLocalDataSourceImpl(
                dataBase,
                entityMapper,
                cacheMapper
            )
            whenever(cacheMapper.mapTo(entityMapperResult)).thenReturn(cacheMapperResult)
            whenever(entityMapper.mapTo(cacheMapperResult)).thenReturn(entityMapperResult)
            whenever(dataBase.getAlbumDao().getAlbumPage(page)).thenReturn(dataBaseResult)
        }
    }

    //region getAlbumList
    @Test
    fun `should return value`() {
        runBlocking {
            assertThat(localDataSource.getAlbumList(page)).isEqualTo(cacheMapperResult)
            verify(dataBase.getAlbumDao(), times(1)).getAlbumPage(page)
        }

    }

    //end region

    //region saveAlbumList

    @Test
    fun `should save album list`() {
        runBlocking {
            localDataSource.saveAlbumList(albumToSaveMockedData)
            verify(dataBase.getAlbumDao(), times(1)).saveAll(entityMapperResult)
        }
    }
    //end region
}