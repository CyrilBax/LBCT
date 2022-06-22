package com.example.album_data.cache

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface AlbumDAO {

    @Query("SELECT * FROM albumentity WHERE albumId IS (:page)")
    fun getAlbumPage(page: Int): List<AlbumEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveAll(AlbumList: List<AlbumEntity>)

}