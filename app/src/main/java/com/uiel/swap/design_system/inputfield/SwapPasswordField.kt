package com.uiel.swap.design_system.inputfield

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.ui.draw.clip
import com.uiel.swap.design_system.SwapColor
import com.uiel.swap.design_system.SwapTypography

object SwapPasswordField {
    @Composable
    fun Password(
        value: String,
        onValueChange: (String) -> Unit,
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        label: String? = null,
        placeholder: String? = null,
        isError: Boolean = false,
        keyboardOptions: KeyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Password),
        interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
        isActive: Boolean = false,
        onClear: (() -> Unit)? = null
    ) {
        var passwordVisible by remember { mutableStateOf(false) }

        Column(modifier = modifier) {
            label?.let {
                Text(
                    text = it,
                    style = SwapTypography.LabelMedium,
                    color = when {
                        isActive -> SwapColor.gray900
                        else -> SwapColor.gray800
                    },
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }

            BasicTextField(
                value = value,
                onValueChange = onValueChange,
                enabled = enabled,
                textStyle = SwapTypography.BodyLarge.copy(
                    color = when {
                        !enabled -> SwapColor.gray450
                        else -> SwapColor.gray900
                    }
                ),
                cursorBrush = SolidColor(SwapColor.main500),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                keyboardOptions = keyboardOptions,
                interactionSource = interactionSource,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(
                        when {
                            !enabled -> SwapColor.gray100
                            isActive -> SwapColor.gray0
                            else -> SwapColor.gray0
                        }
                    )
                    .border(
                        width = 1.dp,
                        color = when {
                            isError -> SwapColor.error
                            isActive -> SwapColor.gray900
                            !enabled -> SwapColor.gray200
                            else -> SwapColor.gray300
                        },
                        shape = RoundedCornerShape(8.dp)
                    ),
                decorationBox = { innerTextField ->
                    Box(
                        modifier = Modifier
                            .padding(16.dp)
                    ) {
                        if (value.isEmpty() && placeholder != null) {
                            Text(
                                text = placeholder,
                                style = SwapTypography.BodyLarge,
                                color = SwapColor.gray450
                            )
                        }
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceBetween
                        ) {
                            Box(modifier = Modifier.weight(1f)) {
                                innerTextField()
                            }
                            Row {
                                if (onClear != null && value.isNotEmpty()) {
                                    IconButton(
                                        onClick = {
                                            onClear()
                                            onValueChange("")
                                        },
                                        modifier = Modifier.size(20.dp)
                                    ) {
                                        Icon(
                                            imageVector = Icons.Default.Clear,
                                            contentDescription = "Clear",
                                            tint = SwapColor.gray450
                                        )
                                    }
                                }
                                IconButton(
                                    onClick = { passwordVisible = !passwordVisible },
                                    modifier = Modifier.size(20.dp)
                                ) {
                                    Icon(
                                        imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                                        contentDescription = if (passwordVisible) "Hide password" else "Show password",
                                        tint = SwapColor.gray450
                                    )
                                }
                            }
                        }
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SwapPasswordFieldPreview() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        SwapPasswordField.Password(
            value = "password",
            onValueChange = {},
            label = "title",
            isActive = true,
            onClear = {}
        )

        SwapPasswordField.Password(
            value = "",
            onValueChange = {},
            label = "title",
            placeholder = "비밀번호를 입력하세요",
            isError = false
        )

        SwapPasswordField.Password(
            value = "password",
            onValueChange = {},
            label = "title",
            isError = true,
            placeholder = "Invalid password"
        )

        SwapPasswordField.Password(
            value = "password",
            onValueChange = {},
            label = "title",
            enabled = false
        )

        SwapPasswordField.Password(
            value = "password",
            onValueChange = {},
            label = "title",
            isActive = true,
            onClear = {}
        )
    }
}
