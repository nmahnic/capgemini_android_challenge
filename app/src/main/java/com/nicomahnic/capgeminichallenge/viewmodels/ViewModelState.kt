package com.nicomahnic.capgeminichallenge.viewmodels

import androidx.paging.PagingData
import com.nicomahnic.capgeminichallenge.models.MarvelItem

data class ViewModelState(
    val data: PagingData<MarvelItem>? = null,
    val spinner: Boolean = true,
)