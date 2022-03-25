package com.example.bindingdemo

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import androidx.constraintlayout.widget.ConstraintLayout
import com.example.bindingdemo.databinding.CustomViewBinding

class CustomViewDemo : ConstraintLayout {

    private var binding: CustomViewBinding =
        CustomViewBinding.inflate(LayoutInflater.from(context), this, true)

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {

        binding.ct1.text = "custom text 1"
        binding.includeId.ct2.text = "custom text 2"
        binding.includeId.ct3.text = "custom text 3"
    }

}