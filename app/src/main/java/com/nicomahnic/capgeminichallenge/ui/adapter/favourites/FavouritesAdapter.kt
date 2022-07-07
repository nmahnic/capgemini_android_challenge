package com.nicomahnic.capgeminichallenge.ui.adapter.favourites

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.nicomahnic.capgeminichallenge.R
import com.nicomahnic.capgeminichallenge.models.MarvelItem

class FavouritesAdapter(
    private var itemsList: List<MarvelItem?>?
) : RecyclerView.Adapter<FavouritesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavouritesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context )
        return FavouritesViewHolder(layoutInflater.inflate(R.layout.item_favourite, parent, false))
    }

    override fun onBindViewHolder(holder: FavouritesViewHolder, position: Int) {
        itemsList?.get(position)?.let { holder.render(it) }
    }

    override fun getItemCount() = itemsList?.size ?: 0

}