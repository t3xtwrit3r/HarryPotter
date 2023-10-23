package com.mubin.harrypotter.ui.characterList

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mubin.harrypotter.api.models.CharacterListResponse
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

    private val _characterList = MutableLiveData<List<CharacterListResponse.CharacterListResponseItem>>()
    val characterList: LiveData<List<CharacterListResponse.CharacterListResponseItem>> = _characterList

    /*init {
        getCharacters()
    }*/

    fun getCharacters() {
        viewModelScope.launch(Dispatchers.IO) {
            val response = repository.getCharacters()
            withContext(Dispatchers.Main) {
                _characterList.value = response
            }
        }
    }

}