package com.example.album_data.factories

import com.example.album_data.cache.AlbumEntity

object AlbumEntityFactory {
    fun getAlbumEntity(page:Int): List<AlbumEntity> {
        return listOf(
            AlbumEntity(
                albumId = 1,
                id = 1,
                title = "accusamus beatae ad facilis cum similique qui sunt",
                url = "https://via.placeholder.com/600/92c952",
                thumbnailUrl = "https://via.placeholder.com/150/92c952"
            ),
            AlbumEntity(
                albumId = 1,
                id = 2,
                title = "reprehenderit est deserunt velit ipsam",
                url = "https://via.placeholder.com/600/771796",
                thumbnailUrl = "https://via.placeholder.com/150/771796"
            )
        )

    }
}