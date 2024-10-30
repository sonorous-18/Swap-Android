package com.uiel.swap.model

data class ChallengeListResponse(
    val title: String,
    val percentage: Int,
    val isClear: Boolean,
    val point: Int,
    val totalPoints: Int,
)