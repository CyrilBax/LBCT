package com.example.album_domain.repositories.profiles

import com.example.album_data.datasources.local.profiles.AlbumLocalDataSourceModule
import com.example.album_data.datasources.remote.profiles.AlbumRemoteDataSourceModule
import com.example.album_domain.repositories.AlbumRepository
import com.example.album_domain.repositories.implementations.AlbumRepositoryImpl
import dagger.Binds
import dagger.Module

@Module(includes = [AlbumLocalDataSourceModule::class, AlbumRemoteDataSourceModule::class])
abstract class AlbumRepositoryModule {

    @Binds
    abstract fun binAlbumRepository(albumRepositoryImpl: AlbumRepositoryImpl): AlbumRepository
}