package com.example.albumlist.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

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