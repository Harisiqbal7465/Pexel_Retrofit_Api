package com.example.pexelretrofitapi.adapter

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.pexelretrofitapi.R
import com.example.pexelretrofitapi.databinding.ListImagePexelBinding
import com.example.pexelretrofitapi.model.imagemodel.Photo

class ImagePexelListAdapter : RecyclerView.Adapter<ImagePexelListAdapter.ViewHolder>() {
    class ViewHolder(val binding: ListImagePexelBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ListImagePexelBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = imageList[position]
        holder.binding.apply {
            imageView.load(currentItem.src.medium) {
                placeholder(R.drawable.ic_baseline_image_24)
            }
        }
    }

    override fun getItemCount() = imageList.size

    private val diffCallBack = object : DiffUtil.ItemCallback<Photo>() {
        override fun areItemsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Photo, newItem: Photo): Boolean {
            return oldItem == newItem
        }
    }

    private val differ = AsyncListDiffer(this, diffCallBack)
    var imageList: List<Photo>
        get() = differ.currentList
        set(value) {
            differ.submitList(value)
        }
}