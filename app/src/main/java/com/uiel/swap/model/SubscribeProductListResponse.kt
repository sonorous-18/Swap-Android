package com.uiel.swap.model

data class SubscribeProductListResponse (
    val id: Long,
    val title: String,
    val thumbnail: String,
    val price: Int,
    val colors: List<Color>,
)