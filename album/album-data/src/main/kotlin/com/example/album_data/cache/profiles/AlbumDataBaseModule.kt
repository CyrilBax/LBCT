package com.example.album_data.cache.profiles

import android.content.Context
import androidx.room.Room
import com.example.album_data.cache.AlbumDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
class AlbumDataBaseModule {

    @Provides
    fun provideAlbumDataBase(
        @ApplicationContext context: Context
    ): AlbumDataBase {
        return Room.databaseBuilder(
            context,
            AlbumDataBase::class.java,
            AlbumDataBase.DATA_BASE_NAME
        ).build()
    }
}