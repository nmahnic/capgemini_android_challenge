package com.nicomahnic.capgeminichallenge.ui.adapter.items

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import com.nicomahnic.capgeminichallenge.R
import com.nicomahnic.capgeminichallenge.domain.models.MarvelItem

class ItemsAdapter(
    private val itemListener: ItemListener
) : PagingDataAdapter<MarvelItem, ItemsViewHolder>(ARTICLE_DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context )
        return ItemsViewHolder(layoutInflater.inflate(R.layout.item_marvel_item, parent, false), )
    }

    override fun onBindViewHolder(holder: ItemsViewHolder, position: Int) {
        val item = getItem(position)
        item?.let { holder.render(it, itemListener) }
    }

    interface ItemListener{
        fun onBtnClick(character: MarvelItem)
    }

    companion object {
        private val ARTICLE_DIFF_CALLBACK = object : DiffUtil.ItemCallback<MarvelItem>() {
            override fun areItemsTheSame(oldItem: MarvelItem, newItem: MarvelItem): Boolean =
                oldItem.id == newItem.id

            override fun areContentsTheSame(oldItem: MarvelItem, newItem: MarvelItem): Boolean =
                oldItem == newItem
        }
    }

}