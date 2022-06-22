package com.example.album_domain.usecases.profiles

import com.example.album_domain.repositories.profiles.AlbumRepositoryModule
import com.example.album_domain.usecases.GetAlbumListUseCase
import com.example.album_domain.usecases.implementations.GetAlbumListUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@InstallIn(ViewModelComponent::class)
@Module(includes = [AlbumRepositoryModule::class])
abstract class GetAlbumListUseCaseModule {

    @Binds
    abstract fun bindGetAlbumListUseCase(getAlbumListUseCaseImpl: GetAlbumListUseCaseImpl): GetAlbumListUseCase
}