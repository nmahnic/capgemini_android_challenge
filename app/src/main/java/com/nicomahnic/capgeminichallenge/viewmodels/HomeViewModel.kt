package com.nicomahnic.capgeminichallenge.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import androidx.paging.filter
import com.nicomahnic.capgeminichallenge.models.MarvelCharacter
import com.nicomahnic.capgeminichallenge.repository.Repository
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class HomeViewModel constructor(
    private val repository: Repository
): ViewModel() {

    private val _state = MutableStateFlow(ViewModelState())
    val state: StateFlow<ViewModelState> get() = _state

    init {
        viewModelScope.launch {
            repository.getCharacters()
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

data class ViewModelState(
    val data: PagingData<MarvelCharacter>? = null,
    val spinner: Boolean = true,
)