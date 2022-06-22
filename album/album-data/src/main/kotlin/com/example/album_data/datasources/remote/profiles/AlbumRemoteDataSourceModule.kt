package com.example.album_data.datasources.remote.profiles

import com.example.album_data.datasources.remote.AlbumRemoteDataSource
import com.example.album_data.datasources.remote.implementations.AlbumRemoteDataSourceImpl
import com.example.album_data.services.profiles.AlbumRemoteModelMapperModule
import com.example.album_data.services.profiles.AlbumServiceModule
import dagger.Binds
import dagger.Module

@Module(includes = [AlbumServiceModule::class, AlbumRemoteModelMapperModule::class])
abstract class AlbumRemoteDataSourceModule {

    @Binds
    abstract fun bindAlbumRemoteDataSource(albumRemoteDataSourceImpl: AlbumRemoteDataSourceImpl): AlbumRemoteDataSource
}