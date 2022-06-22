package com.example.album.feature.mappers

import com.example.album.feature.models.AlbumModelUi
import com.example.album_data.datasources.models.AlbumModel
import com.example.extensions.commons.Mapper
import javax.inject.Inject

class AlbumUiMapper @Inject constructor() :
    Mapper<List<@JvmSuppressWildcards AlbumModel>, List<@JvmSuppressWildcards AlbumModelUi>> {

    override fun mapTo(from: List<AlbumModel>): List<AlbumModelUi> {
        return from.map { mapTo(it) }
    }

    private fun mapTo(from: AlbumModel): AlbumModelUi {
        return AlbumModelUi(
            from.albumId,
            from.id,
            from.title,
            from.url,
            from.thumbnailUrl
        )
    }
}