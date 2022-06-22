package com.example.album_data.services

import com.example.album_data.services.models.AlbumRemoteModel
import retrofit2.http.GET

interface Service {

    @GET(PATH_LIST)
    suspend fun getAlbumList(): List<AlbumRemoteModel>

    companion object {
        private const val PATH_LIST = "img/shared/technical-test.json"
    }
}