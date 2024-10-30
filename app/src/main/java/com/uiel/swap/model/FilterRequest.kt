package com.uiel.swap.model

data class FilterRequest (
    val colors: List<Color>?,
    val startMoney: Int?,
    val endMoney: Int?,
    val spaces: List<Emphysema>?,
)