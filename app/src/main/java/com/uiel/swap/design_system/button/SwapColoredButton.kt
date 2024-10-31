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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.uiel.swap.design_system.DURATION_MILLIS
import com.uiel.swap.design_system.SwapColor
import com.uiel.swap.design_system.SwapText
import com.uiel.swap.design_system.SwapTypography

@Composable
fun SwapColoredButton(
    modifier: Modifier = Modifier,
    text: String,
    small: Boolean = true,
    enabled: Boolean = true,
    shape: RoundedCornerShape = RoundedCornerShape(8.dp),
    keyboardInteractionEnabled: Boolean = true,
    onClick: () -> Unit,
) {
    var pressed by remember { mutableStateOf(false) }

    val background by animateColorAsState(
        targetValue = if (!enabled) {
            SwapColor.gray100
        } else if (pressed) {
            SwapColor.main700
        } else {
            SwapColor.main500
        },
        label = "",
    )

    val contentColor by animateColorAsState(
        targetValue = if (!enabled) {
            SwapColor.gray450
        } else {
            SwapColor.gray0
        },
        animationSpec = tween(durationMillis = DURATION_MILLIS),
        label = "",
    )

    BasicButton(
        modifier = modifier,
        backgroundColor = background,
        shape = shape,
        enabled = enabled,
        keyboardInteractionEnabled = keyboardInteractionEnabled,
        onPressed = { pressed = !pressed },
        onClick = onClick,
        content = {
            SwapText(
                modifier = if (small) {
                    Modifier.padding(
                        horizontal = 20.dp,
                        vertical = 8.dp,
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
                textAlign = TextAlign.Center,
            )
        }
    )
}
