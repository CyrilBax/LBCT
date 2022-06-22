package com.example.album_data.services.profiles

import com.example.album_data.services.AlbumService
import com.example.album_data.services.Service
import com.example.album_data.services.implementations.AlbumServiceImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named

@Module(includes = [AlbumServiceModule.ServiceModule::class])
abstract class AlbumServiceModule {

    @Binds
    abstract fun bindAlbumService(albumServiceImpl: AlbumServiceImpl): AlbumService

    @Module
    class ServiceModule {
        @Provides
        fun provideService(@Named(ALBUM_RETROFIT) retrofit: Retrofit): Service =
            retrofit.create(Service::class.java)

        @Provides
        @Named(ALBUM_RETROFIT)
        fun provideRetrofit(@Named(ALBUM_OKHTTP) okHttpClient: OkHttpClient): Retrofit =
            Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okHttpClient)
                .build()

        @Provides
        @Named(ALBUM_OKHTTP)
        fun provideOkhttp(): OkHttpClient = OkHttpClient().newBuilder().build()

    }

    companion object {
        private const val BASE_URL = "https://static.leboncoin.fr/"
        private const val ALBUM_RETROFIT = "ALBUM_RETROFIT"
        private const val ALBUM_OKHTTP = "ALBUM_OKHTTP"
    }


}