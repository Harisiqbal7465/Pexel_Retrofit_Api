package com.example.pexelretrofitapi.ui.fragments

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.pexelretrofitapi.R
import com.example.pexelretrofitapi.adapter.VideoPexelListAdapter
import com.example.pexelretrofitapi.databinding.FragmentVideoBinding
import com.example.pexelretrofitapi.ui.snackBar
import com.example.pexelretrofitapi.ui.viewModel.MainViewModel
import com.example.pexelretrofitapi.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class VideoFragment : Fragment(R.layout.fragment_video) {
    private var _binding: FragmentVideoBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel: MainViewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentVideoBinding.bind(view)
        viewModel = ViewModelProvider(requireActivity())[MainViewModel::class.java]
        setUpAdapter()
    }

    private fun setUpAdapter() {
        /*val videoAdapter = VideoPexelListAdapter()
        viewModel.getAllVideo()
        lifecycleScope.launch(Dispatchers.IO) {
            viewModel.getAllVideo.collect {
                when (it) {
                    is Resource.Success -> {
                        binding.progressBar.isVisible = false
                        binding.recyclerView.apply {
                            adapter = videoAdapter
                            layoutManager = GridLayoutManager(requireContext(), 3)
                            videoAdapter.videoList = it.data ?: emptyList()
                        }
                    }
                    is Resource.Loading -> {
                        binding.progressBar.isVisible = true
                    }
                    is Resource.Error -> {
                        snackBar(it.message ?: "A unexpected error occured")
                    }
                }
            }
        }*/
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}