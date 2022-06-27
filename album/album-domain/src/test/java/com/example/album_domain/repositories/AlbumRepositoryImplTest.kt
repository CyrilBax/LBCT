package com.example.album_domain.repositories

import com.example.album_data.datasources.local.AlbumLocalDataSource
import com.example.album_data.datasources.models.AlbumModel
import com.example.album_data.datasources.remote.AlbumRemoteDataSource
import com.example.album_domain.repositories.implementations.AlbumRepositoryImpl
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockito_kotlin.*
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test

class AlbumRepositoryImplTest {

    private var repository: AlbumRepositoryImpl = mock()
    private val localDataSource: AlbumLocalDataSource = mock()
    private val remoteDataSource: AlbumRemoteDataSource = mock()
    private val mockedResult: List<AlbumModel> = mock()

    private val page = 1
    private val pageWithoutLocal = 2

    @Before
    fun setup() {
        repository = AlbumRepositoryImpl(
            localDataSource,
            remoteDataSource
        )
        runBlocking {
            whenever(remoteDataSource.getAlbumList()).thenReturn(mockedResult)
            whenever(remoteDataSource.getAlbumList()).thenReturn(mockedResult)
            whenever(localDataSource.getAlbumList(page)).thenReturn(mockedResult)
            whenever(localDataSource.getAlbumList(pageWithoutLocal)).thenReturn(null)
            whenever(remoteDataSource.isOnline()).thenReturn(true)
        }
    }

    @After
    fun clean() {
        clearInvocations(mockedResult)
        clearInvocations(localDataSource)
        clearInvocations(remoteDataSource)
    }

    @Test
    fun `should return value from local`() {
        runBlocking {
            assertThat(repository.getAlbumList(page)).isEqualTo(mockedResult)
            verify(localDataSource, times(1)).getAlbumList(page)
            verify(remoteDataSource, times(0)).getAlbumList()
            verify(remoteDataSource, times(0)).isOnline()
        }
    }

    @Test
    fun `should return value from remote`() {
        runBlocking {
            repository.getAlbumList(pageWithoutLocal)
            verify(localDataSource, times(2)).getAlbumList(pageWithoutLocal)
            verify(remoteDataSource, times(1)).getAlbumList()
            verify(localDataSource, times(1)).saveAlbumList(mockedResult)
            verify(remoteDataSource, times(1)).isOnline()
        }
    }

    @Test
    fun `should return empty list if device is offline`() {
        runBlocking {
            whenever(localDataSource.getAlbumList(page)).thenReturn(mockedResult)
            whenever(remoteDataSource.isOnline()).thenReturn(false)
            repository.getAlbumList(pageWithoutLocal)
            verify(localDataSource, times(1)).getAlbumList(pageWithoutLocal)
            verify(remoteDataSource, times(0)).getAlbumList()
            verify(remoteDataSource, times(1)).isOnline()
        }
    }
}