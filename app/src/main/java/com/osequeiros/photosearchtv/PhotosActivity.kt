package com.osequeiros.photosearchtv

import android.os.Bundle
import androidx.activity.viewModels
import androidx.fragment.app.FragmentActivity
import androidx.lifecycle.lifecycleScope
import com.osequeiros.photosearchtv.presentation.PhotoListViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhotosActivity : FragmentActivity() {

    private val viewModel: PhotoListViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        callServices()
    }

    private fun callServices() {
        lifecycleScope.launchWhenStarted {
            viewModel.getRecent()
            viewModel.search("hello")
        }
    }
}