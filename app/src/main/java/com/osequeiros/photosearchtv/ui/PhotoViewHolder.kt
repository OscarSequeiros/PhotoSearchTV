package com.osequeiros.photosearchtv.ui

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.bumptech.glide.Glide
import com.osequeiros.photosearchtv.R
import com.osequeiros.photosearchtv.databinding.ItemPhotoBinding
import com.osequeiros.photosearchtv.domain.model.Photo

class PhotoViewHolder(
    private val binding: ItemPhotoBinding,
    private val context: Context
) :
    RecyclerView.ViewHolder(binding.root) {

    fun bind(photo: Photo) = with(binding) {
        textAuthorDate.text =
            context.getString(R.string.author_name_and_date, photo.authorName, photo.datePublished)
        textTitle.text = photo.title

        Glide.with(context)
            .load(photo.highResolutionUrl)
            .placeholder(R.drawable.placeholder)
            .error(R.drawable.error)
            .into(imagePhoto)
    }
}