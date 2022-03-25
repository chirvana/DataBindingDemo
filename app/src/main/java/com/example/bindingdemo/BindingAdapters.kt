package com.example.bindingdemo

import android.widget.EditText
import androidx.core.widget.doAfterTextChanged
import androidx.databinding.BindingAdapter

@BindingAdapter("demoListener")
fun handleTextChange(editText: EditText, listener: EditTextListener) {
    editText.doAfterTextChanged {
        listener.onUpdateText(it.toString())
    }
}