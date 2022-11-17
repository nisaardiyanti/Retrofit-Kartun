package com.nisaardiyanti.kartun.viewmodel

import androidx.lifecycle.*
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.nisaardiyanti.kartun.api.ApiService
import com.nisaardiyanti.kartun.paging.RickyMortyPagingSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CharacterViewModel
@Inject
constructor(
    private val apiService: ApiService
) : ViewModel() {

    val listData = Pager(PagingConfig(pageSize = 1)) {
        RickyMortyPagingSource(apiService)

    }.flow.cachedIn(viewModelScope)

}
























