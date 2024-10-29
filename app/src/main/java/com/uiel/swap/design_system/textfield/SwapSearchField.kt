package com.uiel.swap.design_system.textfield

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
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.input.*
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.ui.draw.clip
import com.uiel.swap.design_system.SwapColor
import com.uiel.swap.design_system.SwapTypography

object SwapSearchField {
    @Composable
    fun Search(
        value: String,
        onValueChange: (String) -> Unit,
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        label: String? = null,
        placeholder: String? = null,
        isError: Boolean = false,
        interactionSource: MutableInteractionSource = remember { MutableInteractionSource() },
        isActive: Boolean = false,
        onClear: (() -> Unit)? = null
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
                onValueChange = onValueChange,
                enabled = enabled,
                textStyle = SwapTypography.BodyLarge.copy(
                    color = if (!enabled) SwapColor.gray450 else SwapColor.gray900
                ),
                cursorBrush = SolidColor(SwapColor.main500),
                keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Text),
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
                    Box(
                        modifier = Modifier.padding(16.dp)
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
                                    onClick = {},
                                    modifier = Modifier.size(20.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Search,
                                        contentDescription = "Search",
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
fun SwapSearchFieldPreview() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        SwapSearchField.Search(
            value = "Search input",
            onValueChange = {},
            label = "Search",
            isActive = true,
            onClear = {}
        )

        SwapSearchField.Search(
            value = "",
            onValueChange = {},
            label = "Search",
            placeholder = "Enter search term",
            isError = false
        )

        SwapSearchField.Search(
            value = "Error search",
            onValueChange = {},
            label = "Search",
            isError = true,
            placeholder = "Invalid input"
        )

        SwapSearchField.Search(
            value = "Disabled search",
            onValueChange = {},
            label = "Search",
            enabled = false
        )
    }
}
