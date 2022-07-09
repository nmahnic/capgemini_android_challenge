package com.nicomahnic.capgeminichallenge.ui

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.nicomahnic.capgeminichallenge.R
import com.nicomahnic.capgeminichallenge.databinding.FragmentDescriptionBinding
import com.nicomahnic.capgeminichallenge.utils.Utils
import com.nicomahnic.capgeminichallenge.viewmodels.DescriptionViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class DescriptionFragment : Fragment(R.layout.fragment_description) {

    private lateinit var binding: FragmentDescriptionBinding
    private val viewModel by viewModel<DescriptionViewModel>()
    private val args: DescriptionFragmentArgs by navArgs()

    private var favouriteState: Boolean = false

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentDescriptionBinding.bind(view)

        binding.tvCharacterName.text = args.item.name
        binding.tvReleased.text = "${getString(R.string.modified)} ${Utils.parseModifiedDate(args.item.modified)}"

        val url = Utils.performUls(args.item)
        Glide.with(this).load(url).centerCrop().into(binding.imgBackgroud)

        viewModel.exitsMarvelItem(args.item) {
            favouriteState = it
            if(favouriteState) checkHeart() else uncheckHeart()
        }

        binding.itemFavourite.setOnClickListener {
            favouriteState = !favouriteState
            if(favouriteState) saveMarvelItem() else unsaveMarvelItem()
        }

    }

    private fun unsaveMarvelItem() {
        uncheckHeart()
        viewModel.deleteMarvelItem(args.item)
    }

    private fun saveMarvelItem() {
        checkHeart()
        viewModel.insertMarvelItem(args.item)
    }

    private fun uncheckHeart() {
        binding.imgFavourite.setBackgroundResource(R.drawable.ic_baseline_favorite_border_24)
    }

    private fun checkHeart() {
        binding.imgFavourite.setBackgroundResource(R.drawable.ic_baseline_favorite_24)
    }

}