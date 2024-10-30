package com.uiel.swap.model

data class SubscribeDetailResponse (
    val id: Long,
    val title: String,
    val colors: List<SubscribeDetailColor>,
    val price: Int,
    val detailLink: String,
)

data class SubscribeDetailColor(
    val id: Long,
    val thumbnail: String,
    val color: String,
)
