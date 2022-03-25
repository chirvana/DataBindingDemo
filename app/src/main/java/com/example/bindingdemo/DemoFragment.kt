package com.example.bindingdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
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

        viewModel = ViewModelProvider(this)[DemoViewModel::class.java]

        binding.viewModel = this.viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        viewModel.close.observe(viewLifecycleOwner) {
            activity?.finish()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}