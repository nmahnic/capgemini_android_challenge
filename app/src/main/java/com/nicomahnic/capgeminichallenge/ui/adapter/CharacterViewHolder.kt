package com.nicomahnic.capgeminichallenge.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.nicomahnic.capgeminichallenge.databinding.ItemCharacterBinding
import com.nicomahnic.capgeminichallenge.models.MarvelCharacter

class CharacterViewHolder(view: View): RecyclerView.ViewHolder(view) {

    private var binding = ItemCharacterBinding.bind(view)

    fun render(character: MarvelCharacter, onClickListener: CharacterAdapter.ItemListener){
        binding.tvName.text = character.name
        
        binding.card.setOnClickListener {
            onClickListener.onBtnClick( character )
        }
    }
}