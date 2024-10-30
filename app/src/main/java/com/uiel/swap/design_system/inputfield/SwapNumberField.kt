package com.uiel.swap.design_system.inputfield

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.text.style.TextAlign
import com.uiel.swap.design_system.SwapColor
import com.uiel.swap.design_system.SwapTypography

object SwapNumberField {
    @Composable
    fun Number(
        value: String,
        onValueChange: (String) -> Unit,
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        label: String? = null,
        placeholder: String? = null,
        isError: Boolean = false,
        interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
        isActive: Boolean = false
    ) {
        Column(modifier = modifier) {
            label?.let {
                Text(
                    text = it,
                    style = SwapTypography.LabelMedium,
                    color = if (isActive) SwapColor.gray900 else SwapColor.gray800,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }

            BasicTextField(
                value = value,
                onValueChange = {
                    if (it.all { char -> char.isDigit() || char == ',' }) {
                        onValueChange(it)
                    }
                },
                enabled = enabled,
                textStyle = SwapTypography.BodyLarge.copy(
                    color = if (!enabled) SwapColor.gray450 else SwapColor.gray900,
                    textAlign = TextAlign.End
                ),
                cursorBrush = SolidColor(SwapColor.main500),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                interactionSource = interactionSource,
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(8.dp))
                    .background(
                        color = when {
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
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalArrangement = Arrangement.End // Align everything to the end
                    ) {
                        if (value.isEmpty() && placeholder != null) {
                            Text(
                                text = placeholder,
                                style = SwapTypography.BodyLarge,
                                color = SwapColor.gray450
                            )
                        } else {
                            innerTextField()
                        }
                        Spacer(modifier = Modifier.width(4.dp)) // Add some space between the value and "원"
                        Text(
                            text = "원",
                            style = SwapTypography.BodyLarge,
                            color = if (!enabled) SwapColor.gray450 else SwapColor.gray900
                        )
                    }
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SwapNumberFieldPreview() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        SwapNumberField.Number(
            value = "",
            onValueChange = {},
            label = "title",
            placeholder = "0",
            isActive = true
        )

        SwapNumberField.Number(
            value = "1,000",
            onValueChange = {},
            label = "title",
            isActive = true
        )

        SwapNumberField.Number(
            value = "1,000",
            onValueChange = {},
            label = "title",
            isError = true
        )

        SwapNumberField.Number(
            value = "1,000",
            onValueChange = {},
            label = "title",
            enabled = false
        )
    }
}
