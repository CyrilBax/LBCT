package com.example.album_data.cache.mappers

import com.example.album_data.cache.AlbumEntity
import com.example.album_data.datasources.models.AlbumModel
import com.example.extensions.commons.Mapper
import javax.inject.Inject

class AlbumModelToCacheMapper @Inject constructor()  : Mapper<List<@JvmSuppressWildcards AlbumModel>, List<@JvmSuppressWildcards AlbumEntity>> {

    override fun mapTo(from: List<AlbumModel>): List<AlbumEntity> {
        return from.map { mapTo(it) }
    }

    private fun mapTo(from: AlbumModel): AlbumEntity {
        return AlbumEntity(
            from.albumId,
            from.id,
            from.title,
            from.url,
            from.thumbnailUrl
        )
    }
}