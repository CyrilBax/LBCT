package com.example.album_data.cache

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [AlbumEntity::class], version = 1, exportSchema = false)
abstract class AlbumDataBase : RoomDatabase() {

    abstract fun getAlbumDao(): AlbumDAO

    companion object {
        const val DATA_BASE_NAME = "ALBUM"
    }
}