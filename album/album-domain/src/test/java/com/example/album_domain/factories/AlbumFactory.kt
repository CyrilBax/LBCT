package com.example.album_domain.factories

import com.example.album_data.datasources.models.AlbumModel

object AlbumFactory {

    fun getAlbum(page: Int): List<AlbumModel> {
        return listOf(
            AlbumModel(
                albumId = 1,
                id = 1,
                title = "accusamus beatae ad facilis cum similique qui sunt",
                url = "https://via.placeholder.com/600/92c952",
                thumbnailUrl = "https://via.placeholder.com/150/92c952"
            ),
            AlbumModel(
                albumId = 1,
                id = 2,
                title = "reprehenderit est deserunt velit ipsam",
                url = "https://via.placeholder.com/600/771796",
                thumbnailUrl = "https://via.placeholder.com/150/771796"
            )
        )
    }
}