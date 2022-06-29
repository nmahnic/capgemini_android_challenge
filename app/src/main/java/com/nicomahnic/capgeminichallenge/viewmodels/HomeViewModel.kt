package com.nicomahnic.capgeminichallenge.viewmodels

import android.util.Log
import androidx.lifecycle.ViewModel
import com.nicomahnic.capgeminichallenge.repository.FetchMarvelCharacter
import kotlinx.coroutines.*

class HomeViewModel constructor(
    private val fetchMarvelCharacter: FetchMarvelCharacter
): ViewModel() {

    private var job: Job? = null
    private val exceptionHandler = CoroutineExceptionHandler { _ , throwable ->
        Log.e("NM","Exception: ${throwable.stackTrace}")
    }

    fun fetchCharacters(){
        job = CoroutineScope(Dispatchers.IO + exceptionHandler).launch {
            val response = fetchMarvelCharacter.request()
            withContext(Dispatchers.Main) {
                if(response.isSuccessful) {
                    Log.e("NN", "isSuccessful")
                } else {
                    Log.e("NN", "ERRO ${response.message()}}")
                }
            }
        }
    }

}