package com.osequeiros.photosearchtv

import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import androidx.navigation.findNavController
import com.osequeiros.photosearchtv.databinding.ActivityPhotosBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class PhotosActivity : FragmentActivity() {

    private lateinit var binding: ActivityPhotosBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPhotosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setNavigationGraph()
    }

    private fun setNavigationGraph() {
        val navController = findNavController(R.id.nav_host_photos)
        val navGraph = navController.navInflater.inflate(R.navigation.photos_nav_graph)
        navController.graph = navGraph
    }
}