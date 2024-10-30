package com.uiel.swap.design_system.button

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import com.uiel.swap.design_system.SwapColor

data class ButtonColorSet(
    val background: Color,
    val pressed: Color,
    val text: Color,
)

enum class ButtonColor {
    Primary,
    Secondary,
}

object ButtonColors {
    @Composable
    fun primary() = ButtonColorSet(
        background = SwapColor.main500,
        pressed = SwapColor.main700,
        text = SwapColor.gray0,
    )

    @Composable
    fun secondary() = ButtonColorSet(
        background = SwapColor.main300,
        pressed = SwapColor.main700,
        text = SwapColor.main500,
    )

    @Composable
    fun text() = ButtonColorSet(
        background = Color.Transparent,
        pressed = Color.Transparent,
        text = SwapColor.main500,
    )
}