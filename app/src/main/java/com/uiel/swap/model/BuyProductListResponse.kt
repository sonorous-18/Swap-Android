package com.uiel.swap.model

import java.time.LocalDate

data class BuyProductListResponse (
    val title: String,
    val price: Int,
    val nextBuyDate: LocalDate,
    val useDate: Int,
)