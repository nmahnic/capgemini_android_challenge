package com.nicomahnic.capgeminichallenge.ui.adapter.favourites


import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nicomahnic.capgeminichallenge.databinding.ItemFavouriteBinding
import com.nicomahnic.capgeminichallenge.domain.models.MarvelItem
import com.nicomahnic.capgeminichallenge.ui.utils.Utils

class FavouritesViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private var binding = ItemFavouriteBinding.bind(view)

    fun render(item: MarvelItem){
        binding.tvName.text = item.name

        val url = Utils.performUls(item)
        Glide.with(itemView).load(url).centerCrop().into(binding.imgCharacter)
    }
}