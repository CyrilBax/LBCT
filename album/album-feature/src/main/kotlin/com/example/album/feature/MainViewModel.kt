package com.example.album.feature

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.album.feature.models.AlbumModelUi
import com.example.album_data.datasources.models.AlbumModel
import com.example.album_domain.usecases.GetAlbumListUseCase
import com.example.extensions.commons.Mapper
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAlbumListUseCase: GetAlbumListUseCase,
    private val mapper: Mapper<List<AlbumModel>, List<AlbumModelUi>>
) : ViewModel() {

    private var page = 1

    val albumList: LiveData<List<AlbumModelUi>>
        get() = _albumList

    private val _albumList: MutableLiveData<List<AlbumModelUi>> by lazy {
        MutableLiveData<List<AlbumModelUi>>()
    }

    fun getAlbumList() {
        viewModelScope.launch(Dispatchers.IO) {
            val result = mapper.mapTo(
                getAlbumListUseCase.execute(page)
            )
            page++
            _albumList.postValue(result)
        }
    }
}