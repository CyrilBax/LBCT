package com.example.album_data.cache.profiles

import com.example.album_data.cache.AlbumEntity
import com.example.album_data.cache.mappers.AlbumCacheToModelMapper
import com.example.album_data.datasources.models.AlbumModel
import com.example.extensions.commons.Mapper
import dagger.Module
import dagger.Provides

/*@Module
abstract class AlbumCacheToModelMapperModule {
    @Binds
    abstract fun bindAlbumCacheToModelMapper(albumCacheToModelMapper: AlbumCacheToModelMapper): Mapper<List<AlbumEntity>, List<AlbumModel>>
}*/

@Module
class AlbumCacheToModelMapperModule {
    @Provides
    fun provideAlbumCacheToModelMapper(): Mapper<List<AlbumEntity>, List<AlbumModel>> =
        AlbumCacheToModelMapper()
}