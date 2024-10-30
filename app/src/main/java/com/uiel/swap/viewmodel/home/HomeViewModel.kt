package com.uiel.swap.viewmodel.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uiel.swap.model.Color
import com.uiel.swap.model.Emphysema
import com.uiel.swap.model.SubscribeProductListResponse
import com.uiel.swap.network.Retrofit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val apiService = Retrofit.apiService

    private val _uiState = MutableStateFlow(HomeUiState(
        sub = listOf(),
        colors = emptyList(),
        startMoney = null,
        endMoney = null,
        spaces = emptyList(),
    ))
    val uiState = _uiState.asStateFlow()

    fun updateColors(colors: List<Color>) {
        _uiState.update { it.copy(colors = colors) }
        getSub()
    }

    fun updateStartMoney(startMoney: Int) {
        _uiState.update { it.copy(startMoney = startMoney) }
        getSub()
    }

    fun updateEndMoney(endMoney: Int) {
        _uiState.update { it.copy(endMoney = endMoney) }
        getSub()
    }

    fun updateSpaces(spaces: List<Emphysema>) {
        _uiState.update { it.copy(spaces = spaces) }
        getSub()
    }

    fun getSub() {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                apiService.subscribeProductList(
                    colors = null,
                    startMoney = _uiState.value.startMoney,
                    endMoney = _uiState.value.endMoney,
                    spaces = null,
                )
            }.onSuccess { response ->
                _uiState.update { it.copy(sub = response) }
            }.onFailure {
                Log.d("Home",it.message.toString())
            }
        }
    }
}

data class HomeUiState(
    val sub: List<SubscribeProductListResponse>,
    val colors: List<Color>?,
    val startMoney: Int?,
    val endMoney: Int?,
    val spaces: List<Emphysema>?,

)