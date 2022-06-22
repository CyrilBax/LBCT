package com.example.album_data.cache.mappers

import com.example.album_data.cache.AlbumEntity
import com.example.album_data.datasources.models.AlbumModel
import com.example.extensions.commons.Mapper
import javax.inject.Inject

class AlbumCacheToModelMapper @Inject constructor() :
    Mapper<List<@JvmSuppressWildcards AlbumEntity>, List<@JvmSuppressWildcards AlbumModel>> {

    override fun mapTo(from: List<AlbumEntity>): List<AlbumModel> {
        return from.map { mapTo(it) }
    }

    private fun mapTo(from: AlbumEntity): AlbumModel {
        return AlbumModel(
            from.albumId,
            from.id,
            from.title,
            from.url,
            from.thumbnailUrl
        )
    }
}