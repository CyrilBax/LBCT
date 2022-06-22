package com.example.album.feature.profiles

import com.example.album.feature.mappers.AlbumUiMapper
import com.example.album.feature.models.AlbumModelUi
import com.example.album_data.datasources.models.AlbumModel
import com.example.extensions.commons.Mapper
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module
abstract class AlbumUiMapperModule {
    @Binds
    abstract fun bindAlbumUiMapper(albumUiMapper: AlbumUiMapper) : Mapper<List<AlbumModel>, List<AlbumModelUi>>
}