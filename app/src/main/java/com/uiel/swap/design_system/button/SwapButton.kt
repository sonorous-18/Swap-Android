package com.uiel.swap.design_system.button

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.uiel.swap.design_system.DEFAULT_PRESS_DEPTH
import com.uiel.swap.design_system.MIN_PRESS_DEPTH
import com.uiel.swap.design_system.clickable
import com.uiel.swap.design_system.keyboardAsState

@Composable
internal fun BasicButton(
    modifier: Modifier,
    backgroundColor: Color,
    shape: RoundedCornerShape,
    borderStroke: BorderStroke? = null,
    enabled: Boolean,
    keyboardInteractionEnabled: Boolean,
    onPressed: (pressed: Boolean) -> Unit,
    onClick: () -> Unit,
    content: @Composable () -> Unit,
) {
    val keyboardShow by keyboardAsState()
    val isKeyboardHideButton = keyboardShow && keyboardInteractionEnabled
    val (shapeByKeyboardShow, pressDepth) = if (isKeyboardHideButton) {
        RoundedCornerShape(0.dp) to MIN_PRESS_DEPTH
    } else {
        shape to DEFAULT_PRESS_DEPTH
    }

    Surface(
        modifier = modifier
            .clickable(
                pressDepth = pressDepth,
                enabled = enabled,
                onPressed = onPressed,
                onClick = onClick,
            )
            .then(if (keyboardInteractionEnabled) Modifier.imePadding() else Modifier),
        shape = shapeByKeyboardShow,
        border = borderStroke,
        color = backgroundColor,
        content = content,
        enabled = enabled,
        onClick = onClick,
    )
}
