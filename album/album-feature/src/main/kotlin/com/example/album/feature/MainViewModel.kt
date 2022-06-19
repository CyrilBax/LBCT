package com.example.album.feature

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

//@HiltViewModel
class MainViewModel : ViewModel() {

    val text: LiveData<String>
        get() = _text

    private val _text: MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }

    fun getAlbumList(page: Int) {
        _text.value = "coucou"
    }
}