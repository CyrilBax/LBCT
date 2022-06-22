package com.example.album_data.cache

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [AlbumEntity::class], version = 1, exportSchema = false)
abstract class AlbumDataBase : RoomDatabase() {

    abstract val albumDao: AlbumDAO

    private lateinit var INSTANCE: AlbumDataBase

    fun getDataBase(context: Context): AlbumDataBase {
        synchronized(AlbumDataBase::class.java) {
            if (!::INSTANCE.isInitialized) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,
                    AlbumDataBase::class.java,
                    DATA_BASE_NAME
                ).build()
            }
            return INSTANCE
        }
    }

    companion object {
        const val DATA_BASE_NAME = "ALBUM"
    }
}