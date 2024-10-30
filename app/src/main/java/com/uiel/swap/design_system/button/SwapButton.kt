package com.uiel.swap.design_system.button

import androidx.annotation.DrawableRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.uiel.swap.design_system.DEFAULT_PRESS_DEPTH
import com.uiel.swap.design_system.DURATION_MILLIS
import com.uiel.swap.design_system.MIN_PRESS_DEPTH
import com.uiel.swap.design_system.SwapColor
import com.uiel.swap.design_system.SwapText
import com.uiel.swap.design_system.clickable
import com.uiel.swap.design_system.keyboardAsState

@Composable
internal fun BasicButton(
    modifier: Modifier,
    backgroundColor: Color,
    shape: RoundedCornerShape,
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
            //.padding(padding)
            .then(if (keyboardInteractionEnabled) Modifier.imePadding() else Modifier),
        shape = shapeByKeyboardShow,
        color = backgroundColor,
        content = content,
        enabled = enabled,
        onClick = onClick,
    )
}
