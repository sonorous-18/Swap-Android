package com.uiel.swap.viewmodel.benefit

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uiel.swap.model.ChallengeListResponse
import com.uiel.swap.network.Retrofit
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class BenefitViewModel : ViewModel() {
    private val apiService = Retrofit.apiService

    private val _uiState = MutableStateFlow(BenefitUiState(listOf()))
    val uiState = _uiState.asStateFlow()

    fun getChallenge() {
        viewModelScope.launch(Dispatchers.IO) {
            runCatching {
                apiService.challengeList()
            }.onSuccess { response ->
                _uiState.update { it.copy(challenge = response) }
            }.onFailure {
                Log.d("Benefit",it.message.toString())
            }
        }
    }
}

data class BenefitUiState(
    val challenge: List<ChallengeListResponse>
)