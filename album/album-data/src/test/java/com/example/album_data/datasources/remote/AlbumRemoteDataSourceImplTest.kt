package com.example.album_data.datasources.remote

import android.content.Context
import com.example.album_data.datasources.models.AlbumModel
import com.example.album_data.datasources.remote.implementations.AlbumRemoteDataSourceImpl
import com.example.album_data.services.AlbumService
import com.example.album_data.services.mappers.AlbumRemoteModelMapper
import com.example.album_data.services.models.AlbumRemoteModel
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class AlbumRemoteDataSourceImplTest {

    private lateinit var remoteDataSource: AlbumRemoteDataSourceImpl
    private val service: AlbumService = mock()
    private val mapper: AlbumRemoteModelMapper = mock()
    private val mockedContext: Context = mock()
    private val mockedResult: List<AlbumModel> = mock()
    private val mockedDataMapper: List<AlbumRemoteModel> = mock()

    private val page = 1

    @Before
    fun setup() {
        remoteDataSource = AlbumRemoteDataSourceImpl(
            service,
            mapper,
            mockedContext
        )
        runBlocking {
            whenever(service.getAlbumList(page)).thenReturn(mockedDataMapper)
            whenever(mapper.mapTo(mockedDataMapper)).thenReturn(mockedResult)
        }
    }

    //region getAlbumList

    @Test
    fun `should return value`() {
        runBlocking {
            assertThat(remoteDataSource.getAlbumList(page)).isEqualTo(mockedResult)
            verify(mapper, times(1)).mapTo(mockedDataMapper)
        }
    }

    //end region
}