package com.example.album_data.datasources.local.profiles

import com.example.album_data.cache.profiles.AlbumCacheToModelMapperModule
import com.example.album_data.cache.profiles.AlbumDataBaseModule
import com.example.album_data.cache.profiles.AlbumModelToCacheMapperModule
import com.example.album_data.datasources.local.AlbumLocalDataSource
import com.example.album_data.datasources.local.implementations.AlbumLocalDataSourceImpl
import dagger.Binds
import dagger.Module

@Module(includes = [AlbumDataBaseModule::class, AlbumCacheToModelMapperModule::class, AlbumModelToCacheMapperModule::class])
abstract class AlbumLocalDataSourceModule {

    @Binds
    abstract fun bindAlbumLocalDataSource(albumLocalDataSourceImpl: AlbumLocalDataSourceImpl): AlbumLocalDataSource
}