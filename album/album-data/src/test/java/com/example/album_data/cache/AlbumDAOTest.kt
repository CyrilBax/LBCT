package com.example.album_data.cache

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.nhaarman.mockito_kotlin.mock
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AlbumDAOTest {
    private lateinit var albumDataBase: AlbumDataBase
    private lateinit var albumDAO: AlbumDAO

    @Before
    fun setup() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        albumDataBase = Room.inMemoryDatabaseBuilder(
            context,
            AlbumDataBase::class.java
        ).build()
        albumDAO = albumDataBase.albumDao
    }

    @After
    fun closeDataBase() {
        albumDataBase.close()
    }

    @Test
    fun `should save and read album list`() {
        val albumListToSave: List<AlbumEntity> = mock()
        val albumToRead: List<AlbumEntity> = mock()

        albumDataBase.albumDao.saveAll(albumListToSave)
        assertThat(albumDataBase.albumDao.getAlbumPage(1)).isEqualTo(albumToRead)
    }

}