package com.example.bindingdemo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DemoViewModel : ViewModel(), EditTextListener {

    private val _liveText = MutableLiveData<String>()
    val liveText : LiveData<String> = _liveText

    private val _close = MutableLiveData<Unit>()
    val close : LiveData<Unit> = _close

    override
    fun onUpdateText(text: String) {
        _liveText.value = text
    }

    fun onClose() {
        _close.value = Unit
    }
}

interface EditTextListener {
    fun onUpdateText(text: String)
}