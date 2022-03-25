package com.example.bindingdemo

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.doAfterTextChanged
import com.example.bindingdemo.databinding.DemoFragmentBinding

class DemoFragment : Fragment() {

    private var _binding: DemoFragmentBinding? = null
    // This property is only valid between onCreateView and onDestroyView.
    // Fragments outlive their views. Make sure you clean up any references to the binding
    // class instance in the fragment's onDestroyView() method.
    private val binding
        get() = _binding!!

    companion object {
        fun newInstance() = DemoFragment()
    }

    private lateinit var viewModel: DemoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DemoFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DemoViewModel::class.java)

        binding.editText.doAfterTextChanged {
            binding.textView2.text = it.toString()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}