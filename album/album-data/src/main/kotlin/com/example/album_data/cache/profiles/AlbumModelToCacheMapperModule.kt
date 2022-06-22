package com.example.album_data.cache.profiles

import com.example.album_data.cache.AlbumEntity
import com.example.album_data.cache.mappers.AlbumModelToCacheMapper
import com.example.album_data.datasources.models.AlbumModel
import com.example.extensions.commons.Mapper
import dagger.Module
import dagger.Provides

/*
@Module
abstract class AlbumModelToCacheMapperModule {
    @Binds
    abstract fun bindAlbumModelToCacheMapper(albumModelToCacheMapper: AlbumModelToCacheMapper): Mapper<List<AlbumModel>, List<AlbumEntity>>
}
*/

@Module
class AlbumModelToCacheMapperModule {
    @Provides
    fun provideAlbumModelToCacheMapper(): Mapper<List<AlbumModel>, List<AlbumEntity>> =
        AlbumModelToCacheMapper()
}