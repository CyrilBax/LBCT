package com.example.album_data.datasources.remote.implementations

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import androidx.core.content.ContextCompat.getSystemService
import com.example.album_data.datasources.models.AlbumModel
import com.example.album_data.datasources.remote.AlbumRemoteDataSource
import com.example.album_data.services.AlbumService
import com.example.album_data.services.models.AlbumRemoteModel
import com.example.extensions.commons.Mapper
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class AlbumRemoteDataSourceImpl @Inject constructor(
    private val service: AlbumService,
    private val mapper: Mapper<List<AlbumRemoteModel>, List<AlbumModel>>,
    @ApplicationContext private val context: Context
) : AlbumRemoteDataSource {
    override suspend fun getAlbumList(page: Int): List<AlbumModel> =
        mapper.mapTo(service.getAlbumList(page))

    override suspend fun isOnline(): Boolean {
        val connMgr =
            getSystemService(context, ConnectivityManager::class.java) as ConnectivityManager
        val networkInfo: NetworkInfo? = connMgr.activeNetworkInfo
        return networkInfo?.isConnected == true
    }
}