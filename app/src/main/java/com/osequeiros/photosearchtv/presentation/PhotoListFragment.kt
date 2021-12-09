package com.osequeiros.photosearchtv.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.osequeiros.photosearchtv.databinding.FragmentPhotoListBinding
import com.osequeiros.photosearchtv.domain.model.Photo
import com.osequeiros.photosearchtv.presentation.userintent.PhotoListUserIntent
import com.osequeiros.photosearchtv.presentation.viewstate.PhotoListViewState
import com.osequeiros.photosearchtv.presentation.viewstate.PhotoListViewState.*
import com.osequeiros.photosearchtv.ui.PhotosGridAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect

@AndroidEntryPoint
class PhotoListFragment : Fragment() {

    private var binding: FragmentPhotoListBinding? = null

    private val viewModel: PhotoListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPhotoListBinding.inflate(layoutInflater)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeStates()
    }

    private fun observeStates() {
        lifecycleScope.launchWhenStarted {
            viewModel.process(PhotoListUserIntent.SeeRecentPhotosDefaultIntent)
                .collect { viewState -> render(viewState) }
        }
    }

    private fun render(viewState: PhotoListViewState) {
        when (viewState) {
            is LoadingState -> {
            }
            is EmptyState -> {
            }
            is PhotosState -> binding?.showPhotos(viewState.photos)
            is ErrorState -> {
            }
        }
    }

    private fun FragmentPhotoListBinding.showPhotos(photos: List<Photo>) {
        val adapter = PhotosGridAdapter(photos)

        recyclerPhotos.layoutManager = GridLayoutManager(context!!, 3)
        recyclerPhotos.adapter = adapter
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}