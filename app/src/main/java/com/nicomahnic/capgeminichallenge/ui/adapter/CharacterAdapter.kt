package com.nicomahnic.capgeminichallenge.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.nicomahnic.capgeminichallenge.R
import com.nicomahnic.capgeminichallenge.models.MarvelCharacter

class CharacterAdapter(
    private val itemListener: ItemListener
) : PagingDataAdapter<MarvelCharacter ,CharacterViewHolder>(ARTICLE_DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context )
        return CharacterViewHolder(layoutInflater.inflate(R.layout.item_character, parent, false), )
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val item = getItem(position)
        item?.let { holder.render(it, itemListener) }
    }

    interface ItemListener{
        fun onBtnClick(character: MarvelCharacter)
    }

    companion object {
        private val ARTICLE_DIFF_CALLBACK = object : DiffUtil.ItemCallback<MarvelCharacter>() {
            override fun areItemsTheSame(oldItem: MarvelCharacter, newItem: MarvelCharacter): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: MarvelCharacter, newItem: MarvelCharacter): Boolean =
                oldItem == newItem
        }
    }

}