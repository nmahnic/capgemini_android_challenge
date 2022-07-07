package com.nicomahnic.capgeminichallenge.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.nicomahnic.capgeminichallenge.R
import com.nicomahnic.capgeminichallenge.databinding.FragmentFavouriteBinding
import com.nicomahnic.capgeminichallenge.viewmodels.FavouriteViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavouriteFragment : Fragment(R.layout.fragment_favourite) {

    private lateinit var binding: FragmentFavouriteBinding
    private val viewModel by viewModel<FavouriteViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentFavouriteBinding.bind(view)

        viewModel.getFavouriteMarvelItems()

    }

}