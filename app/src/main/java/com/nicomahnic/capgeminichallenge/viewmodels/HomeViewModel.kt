package com.nicomahnic.capgeminichallenge.viewmodels

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
    val state: StateFlow<ViewModelState> get() = _state

    init {
        viewModelScope.launch {
            getMarvelItemsFromPagingUseCase.task()
                .cachedIn(viewModelScope)
                .collectLatest { characters ->
                _state.value = ViewModelState(
                    characters,
                    false
                )
            }
        }
    }

}

