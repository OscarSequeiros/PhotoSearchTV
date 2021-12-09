package com.osequeiros.photosearchtv.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import com.osequeiros.photosearchtv.databinding.FragmentPhotoListBinding
import com.osequeiros.photosearchtv.domain.model.Photo
import com.osequeiros.photosearchtv.presentation.PhotoListViewModel
import com.osequeiros.photosearchtv.presentation.userintent.PhotoListUserIntent
import com.osequeiros.photosearchtv.presentation.userintent.PhotoListUserIntent.*
import com.osequeiros.photosearchtv.presentation.viewstate.PhotoListViewState
import com.osequeiros.photosearchtv.presentation.viewstate.PhotoListViewState.*
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.distinctUntilChanged

@AndroidEntryPoint
class PhotoListFragment : Fragment() {

    private var binding: FragmentPhotoListBinding? = null

    private val viewModel: PhotoListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        if (binding == null) {
            binding = FragmentPhotoListBinding.inflate(layoutInflater)
            viewModel.process(SeeRecentPhotosDefaultIntent)
            observeStates()
        }
        return binding?.root
    }

    private fun observeStates() {
        lifecycleScope.launchWhenStarted {
            viewModel.state.collect { viewState -> binding?.render(viewState) }
        }
    }

    private fun FragmentPhotoListBinding.render(viewState: PhotoListViewState) {
        when (viewState) {
            is LoadingState -> showLoading()
            is EmptyState -> showEmptyState()
            is PhotosState -> showPhotos(viewState.photos)
            is ErrorState -> showError(viewState.error)
        }
    }

    private fun FragmentPhotoListBinding.showLoading() {
        progressLoading.visibility = View.VISIBLE
    }

    private fun FragmentPhotoListBinding.showEmptyState() {
        hideLoading()
        // TODO: [Tech note] We can use a template for empty states.
    }

    private fun FragmentPhotoListBinding.showError(error: Throwable) {
        hideLoading()
        // TODO: [Tech note] We can use a template for errors.
        //  Also, we can track the error with some tools like Crashlytics
    }

    private fun FragmentPhotoListBinding.showPhotos(photos: List<Photo>) {
        hideLoading()
        val adapter = PhotosGridAdapter(photos) { url ->
            val action = PhotoListFragmentDirections.actionToDetail(url)
            findNavController().navigate(action)
        }

        context?.let { safeContext ->
            recyclerPhotos.layoutManager = GridLayoutManager(safeContext, 3)
            recyclerPhotos.adapter = adapter
        }
    }

    private fun FragmentPhotoListBinding.hideLoading() {
        progressLoading.visibility = View.GONE
    }
}