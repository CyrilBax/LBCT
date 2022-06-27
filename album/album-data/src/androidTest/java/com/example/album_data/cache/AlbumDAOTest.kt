package com.example.album_data.cache

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.album_data.factories.AlbumEntityFactory
import org.hamcrest.CoreMatchers.equalTo
import org.hamcrest.MatcherAssert.assertThat
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

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
        albumDAO = albumDataBase.getAlbumDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDataBase() {
        albumDataBase.close()
    }

    @Test
    fun shouldSaveAndReadAlbumList() {
        val albumList = AlbumEntityFactory.getAlbumEntity(1)
        albumDAO.saveAll(albumList)
        val result = albumDAO.getAlbumPage(1)
        assertThat(result, equalTo(albumList))
    }

}