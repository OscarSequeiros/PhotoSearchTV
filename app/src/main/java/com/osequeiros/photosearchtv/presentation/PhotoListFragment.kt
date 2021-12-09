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
                .collect { viewState -> binding?.render(viewState) }
        }
    }

    private fun FragmentPhotoListBinding.render(viewState: PhotoListViewState) {
        when (viewState) {
            is LoadingState -> showLoading()
            is EmptyState -> {
            }
            is PhotosState -> showPhotos(viewState.photos)
            is ErrorState -> {
            }
        }
    }

    private fun FragmentPhotoListBinding.showLoading() {
        progressLoading.visibility = View.VISIBLE
    }

    private fun FragmentPhotoListBinding.showPhotos(photos: List<Photo>) {
        hideLoading()
        val adapter = PhotosGridAdapter(photos)

        context?.let { safeContext ->
            recyclerPhotos.layoutManager = GridLayoutManager(safeContext, 3)
            recyclerPhotos.adapter = adapter
        }
    }

    private fun FragmentPhotoListBinding.hideLoading() {
        progressLoading.visibility = View.GONE
    }

    override fun onDestroyView() {
        binding = null
        super.onDestroyView()
    }
}