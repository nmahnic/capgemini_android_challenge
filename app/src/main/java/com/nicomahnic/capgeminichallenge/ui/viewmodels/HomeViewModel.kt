package com.nicomahnic.capgeminichallenge.ui.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.nicomahnic.capgeminichallenge.domain.GetMarvelItemsFromPagingUseCase
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class HomeViewModel constructor(
    private val getMarvelItemsFromPagingUseCase: GetMarvelItemsFromPagingUseCase
): ViewModel() {

    private val _state = MutableStateFlow(ViewModelState())
    var state: StateFlow<ViewModelState> get() = _state
        set(value) {state = value}

    init {
        viewModelScope.launch {
            getMarvelItemsFromPagingUseCase()
                .cachedIn(viewModelScope)
                .collectLatest { items -> _state.value = ViewModelState(items) }
        }
    }

    fun notLoading(state: ViewModelState){
        viewModelScope.launch { _state.value = state }
    }

}

