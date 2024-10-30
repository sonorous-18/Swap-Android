package com.uiel.swap.model

import java.time.LocalTime

data class SaveBikeRequest (
    val pictures: List<String>,
    val title: String,
    val year: Int,
    val mo: Boolean,
    val tu: Boolean,
    val we: Boolean,
    val th: Boolean,
    val fr: Boolean,
    val sa: Boolean,
    val su: Boolean,
    val startTime: LocalTime,
    val endTime: LocalTime,
)