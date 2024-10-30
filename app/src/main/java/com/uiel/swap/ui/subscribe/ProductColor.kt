package com.uiel.swap.ui.subscribe

import androidx.compose.ui.graphics.Color

enum class ProductColor(val colorName: String, val colorValue: Color) {
    BLACK("BLACK", Color.Black),
    BEIGE("BEIGE", Color(0xFFEEE5CE)),
    PURPLE("PURPLE", Color(0xFF8A2BE2)),
    SILVER("SILVER", Color.LightGray),
    SKY_BLUE("SKY_BLUE", Color(0xFF87CEEB)),
    WHITE("WHITE", Color.White);

    companion object {
        fun fromName(name: String): ProductColor? = values().find { it.name == name }
    }
}
