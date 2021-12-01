package com.example.pexelretrofitapi.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pexelretrofitapi.R
import com.example.pexelretrofitapi.adapter.ImagePexelListAdapter
import com.example.pexelretrofitapi.databinding.FragmentImagePexelBinding
import com.example.pexelretrofitapi.ui.snackBar
import com.example.pexelretrofitapi.ui.viewModel.MainViewModel
import com.example.pexelretrofitapi.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch


class ImagePexelFragment : Fragment(R.layout.fragment_image_pexel) {
    private var _binding: FragmentImagePexelBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MainViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentImagePexelBinding.bind(view)
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]

        setUpAdapter()
    }

    private fun setUpAdapter() {
        val imageAdapter = ImagePexelListAdapter()
        lifecycleScope.launch(Dispatchers.Main) {
            viewModel.getAllImages(1, 80)
            viewModel.getAllPhotos.collectLatest { resource ->
                when (resource) {
                    is Resource.Success -> {
                        binding.progressBar.isVisible = false
                        binding.recyclerView.apply {
                            imageAdapter.imageList = resource.data ?: emptyList()
                            Log.i("check","data = ${resource.data}")
                            adapter = imageAdapter
                            layoutManager = GridLayoutManager(requireContext(), 2)
                        }
                    }
                    is Resource.Loading -> {
                        binding.progressBar.isVisible = true
                    }
                    is Resource.Error -> {
                        binding.progressBar.isVisible = false
                        snackBar(resource.message ?: "A unexpected error occured")
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

