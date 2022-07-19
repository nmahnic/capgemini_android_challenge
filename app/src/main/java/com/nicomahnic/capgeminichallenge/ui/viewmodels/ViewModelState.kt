package com.nicomahnic.capgeminichallenge.ui.viewmodels

import androidx.paging.PagingData
import com.nicomahnic.capgeminichallenge.domain.models.MarvelItem

data class ViewModelState(
    val data: PagingData<MarvelItem>? = null,
    val spinner: Boolean = true,
)