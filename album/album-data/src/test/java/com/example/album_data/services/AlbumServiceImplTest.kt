package com.example.album_data.services

import com.example.album_data.services.implementations.AlbumServiceImpl
import com.example.album_data.services.models.AlbumRemoteModel
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class AlbumServiceImplTest {
    private lateinit var albumService: AlbumServiceImpl
    private val service: Service = mock()

    private val albumMock: List<AlbumRemoteModel> = mock()


    @Before
    fun setup() {
        runBlocking {
            albumService = AlbumServiceImpl(service)
            whenever(service.getAlbumList()).thenReturn(albumMock)
        }
    }

    @Test
    fun `shoudl return correct value`() {
        runBlocking {
            assertThat(albumService.getAlbumList()).isEqualTo(albumMock)
            verify(service, times(1)).getAlbumList()
        }
    }

}