package com.example.album_data.services.profiles

import com.example.album_data.datasources.models.AlbumModel
import com.example.album_data.services.mappers.AlbumRemoteModelMapper
import com.example.album_data.services.models.AlbumRemoteModel
import com.example.extensions.commons.Mapper
import dagger.Binds
import dagger.Module

@Module
abstract class AlbumRemoteModelMapperModule {
    @Binds
    abstract fun bindAlbumRemoteModelMapper(albumRemoteModelMapper: AlbumRemoteModelMapper): Mapper<List<AlbumRemoteModel>, List<AlbumModel>>
}