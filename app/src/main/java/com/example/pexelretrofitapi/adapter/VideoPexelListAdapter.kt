package com.example.pexelretrofitapi.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.pexelretrofitapi.databinding.ListImagePexelBinding
import com.example.pexelretrofitapi.databinding.ListVideoPexelBinding
import com.example.pexelretrofitapi.model.imagemodel.Photo
import com.example.pexelretrofitapi.model.videomodel.Video

class VideoPexelListAdapter: RecyclerView.Adapter<VideoPexelListAdapter.ViewHolder>() {
    class ViewHolder(val binding: ListVideoPexelBinding): RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ListVideoPexelBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = videoList[position]

    }

    override fun getItemCount() = videoList.size

    private val diffCallBack = object: DiffUtil.ItemCallback<Video>(){
        override fun areItemsTheSame(oldItem: Video, newItem: Video): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Video, newItem: Video): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallBack)

    var videoList: List<Video>
        get() = differ.currentList
        set(value){ differ.submitList(value)}

}