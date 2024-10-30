package com.uiel.swap.design_system.button

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.uiel.swap.design_system.DURATION_MILLIS
import com.uiel.swap.design_system.SwapColor
import com.uiel.swap.design_system.SwapText
import com.uiel.swap.design_system.SwapTypography

@Composable
fun SwapTextButton(
    modifier: Modifier = Modifier,
    text: String,
    small: Boolean = true,
    enabled: Boolean = true,
    keyboardInteractionEnabled: Boolean = true,
    onClick: () -> Unit,
) {
    var pressed by remember { mutableStateOf(false) }

    val contentColor by animateColorAsState(
        targetValue = if (!enabled) {
            SwapColor.gray450
        } else if (pressed) {
            SwapColor.main700
        } else {
            SwapColor.main500
        },
        animationSpec = tween(durationMillis = DURATION_MILLIS),
        label = "",
    )

    BasicButton(
        modifier = modifier,
        backgroundColor = Color.Transparent,
        shape = RoundedCornerShape(8.dp),
        enabled = enabled,
        keyboardInteractionEnabled = keyboardInteractionEnabled,
        onPressed = { pressed = !pressed },
        onClick = onClick,
        content = {
            SwapText(
                modifier = if (small) {
                    Modifier.padding(
                        horizontal = 20.dp,
                        vertical = 6.dp,
                    )
                } else {
                    Modifier.padding(
                        horizontal = 32.dp,
                        vertical = 12.dp,
                    )
                },
                text = text,
                style = SwapTypography.TitleMedium,
                color = contentColor,
            )
        }
    )
}
