package com.mubin.harrypotter.ui.characterList

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mubin.harrypotter.repository.AppRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel
@Inject
constructor(private val repository: AppRepository): ViewModel() {

    /*init {
        getCharacters()
    }*/

    fun getCharacters() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getCharacters()
            withContext(Dispatchers.Main) {
                Log.d("responseFromApi", "${response.size}")
            }
        }
    }

}