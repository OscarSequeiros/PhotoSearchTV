package com.osequeiros.photosearchtv.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.osequeiros.photosearchtv.databinding.ItemPhotoBinding
import com.osequeiros.photosearchtv.domain.model.Photo

class PhotosGridAdapter(
    private val photos: List<Photo>,
    private val onPhotoClick: (String) -> Unit = {},
) : RecyclerView.Adapter<PhotoViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding = ItemPhotoBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoViewHolder(binding, parent.context)
    }

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        holder.bind(photos[position], onPhotoClick)
    }

    override fun getItemCount(): Int {
        return photos.size
    }
}