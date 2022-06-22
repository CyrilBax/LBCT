package com.example.album_domain.usecases.implementations

import com.example.album_domain.repositories.AlbumRepository
import com.example.album_domain.usecases.GetAlbumListUseCase
import javax.inject.Inject

class GetAlbumListUseCaseImpl @Inject constructor(
    private val repository: AlbumRepository
) : GetAlbumListUseCase {
    override suspend fun execute(page: Int) = repository.getAlbumList(page)

}