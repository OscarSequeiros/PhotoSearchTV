package com.osequeiros.photosearchtv.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.osequeiros.photosearchtv.R
import com.osequeiros.photosearchtv.databinding.FragmentPhotoDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhotoDetailFragment : Fragment() {

    private var binding: FragmentPhotoDetailBinding? = null

    // TODO [Tech note]: It would be better to pass only the ID and with it get the details,
    //  with that approach we could achieve navigate to the next and previous photos.
    private val args: PhotoDetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPhotoDetailBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.setupImage()
    }

    private fun FragmentPhotoDetailBinding.setupImage() {
        context?.let { safeContext ->
            Glide.with(safeContext)
                .load(args.imageUrl)
                .placeholder(R.drawable.placeholder)
                .error(R.drawable.error)
                .into(imagePhoto)
        }
    }
}