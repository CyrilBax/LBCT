package com.example.album_domain.usecases

import com.example.album_data.datasources.models.AlbumModel
import com.example.album_domain.factories.AlbumFactory
import com.example.album_domain.repositories.AlbumRepository
import com.example.album_domain.usecases.implementations.GetAlbumListUseCaseImpl
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockito_kotlin.mock
import com.nhaarman.mockito_kotlin.whenever
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetAlbumListImplTest {

    private lateinit var useCase: GetAlbumListUseCaseImpl
    private val repository: AlbumRepository = mock()
    private val mockedResult: List<AlbumModel> = mock()

    private val page = 1


    @Before
    fun setup() {
        useCase = GetAlbumListUseCaseImpl(repository)
        runBlocking {
            whenever(repository.getAlbumList(page)).thenReturn(AlbumFactory.getAlbum(page))
        }
    }

    @Test
    fun `check return value`() {
        runBlocking {
            assertThat(useCase.execute(page)).isEqualTo(AlbumFactory.getAlbum(page))
        }
    }


}