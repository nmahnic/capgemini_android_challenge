package com.nicomahnic.capgeminichallenge.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.nicomahnic.capgeminichallenge.R
import com.nicomahnic.capgeminichallenge.databinding.FragmentFavouriteBinding
import com.nicomahnic.capgeminichallenge.ui.adapter.favourites.FavouritesAdapter
import com.nicomahnic.capgeminichallenge.ui.viewmodels.FavouriteViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavouriteFragment : Fragment(R.layout.fragment_favourite) {

    private lateinit var binding: FragmentFavouriteBinding
    private val viewModel by viewModel<FavouriteViewModel>()
    private lateinit var adapter: FavouritesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentFavouriteBinding.bind(view)


        CoroutineScope(Dispatchers.Main).launch {
            viewModel.getFavouriteMarvelItems().collect{
                binding.rvFavourite.layoutManager = LinearLayoutManager(requireContext())
                adapter = FavouritesAdapter(it)
                binding.rvFavourite.adapter = adapter
            }
        }

    }

}