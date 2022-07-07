package com.nicomahnic.capgeminichallenge.ui.adapter.items

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.nicomahnic.capgeminichallenge.databinding.ItemMarvelItemBinding
import com.nicomahnic.capgeminichallenge.models.MarvelItem
import com.nicomahnic.capgeminichallenge.utils.Utils

class ItemsViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private var binding = ItemMarvelItemBinding.bind(view)

    fun render(character: MarvelItem, onClickListener: ItemsAdapter.ItemListener){
        binding.tvName.text = character.name

        val url = Utils.performUls(character)
        Glide.with(itemView).load(url).centerCrop().into(binding.imgCharacter)
        
        binding.card.setOnClickListener {
            onClickListener.onBtnClick( character )
        }
    }
}