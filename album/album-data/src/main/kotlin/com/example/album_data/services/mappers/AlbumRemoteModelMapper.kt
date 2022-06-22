package com.example.album_data.services.mappers

import com.example.album_data.datasources.models.AlbumModel
import com.example.album_data.services.models.AlbumRemoteModel
import com.example.extensions.commons.Mapper
import javax.inject.Inject

class AlbumRemoteModelMapper @Inject constructor() :
    Mapper<List<@JvmSuppressWildcards AlbumRemoteModel>, List<@JvmSuppressWildcards AlbumModel>> {

    override fun mapTo(from: List<AlbumRemoteModel>): List<AlbumModel> {
        return from.map { mapToModel(it) }
    }

    private fun mapToModel(from: AlbumRemoteModel): AlbumModel {
        return AlbumModel(
            from.albumId,
            from.id,
            from.title,
            from.url,
            from.thumbnailUrl
        )
    }
}