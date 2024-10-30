package com.uiel.swap.viewmodel.subscribe

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uiel.swap.model.SubscribeDetailResponse
import com.uiel.swap.network.Retrofit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class SubscribeDetailViewModel : ViewModel() {
    private val apiService = Retrofit.apiService

    private val _uiState = MutableStateFlow(SubscribeDetailUiState())
    val uiState = _uiState.asStateFlow()

    fun getSubscribeDetail(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                apiService.subscribeDetail(id)
            }.onSuccess { response ->
                _uiState.update { it.copy(detail = response) }
            }.onFailure {
                Log.d("SubscribeDetail", it.message.toString())
            }
        }
    }
}

data class SubscribeDetailUiState(
    val detail: SubscribeDetailResponse? = null
)
