package com.uiel.swap.design_system.textfield

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uiel.swap.design_system.SwapColor
import com.uiel.swap.design_system.SwapTypography
import com.uiel.swap.R

object SwapSelectField {
    @Composable
    fun Select(
        selectedOption: String?,
        onOptionSelected: (String) -> Unit,
        modifier: Modifier = Modifier,
        enabled: Boolean = true,
        label: String? = null,
        placeholder: String = "Option",
        isError: Boolean = false,
        isActive: Boolean = false,
        options: List<String> = listOf("Option 1", "Option 2", "Option 3"),
        interactionSource: MutableInteractionSource = remember { MutableInteractionSource() }
    ) {
        var expanded by remember { mutableStateOf(false) }

        Column(modifier = modifier) {
            label?.let {
                Text(
                    text = it,
                    style = SwapTypography.LabelMedium,
                    color = if (isActive) SwapColor.gray900 else SwapColor.gray800,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
            }

            Box(
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
                    )
                    .clickable(
                        interactionSource = interactionSource,
                        indication = null,
                        enabled = enabled
                    ) { expanded = !expanded }
                    .padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = selectedOption ?: placeholder,
                        style = SwapTypography.BodyLarge,
                        color = if (selectedOption == null) SwapColor.gray450 else if (!enabled) SwapColor.gray450 else SwapColor.gray900,
                        textAlign = TextAlign.Start
                    )

                    Icon(
                        painter = painterResource(
                            id = if (expanded) R.drawable.ic_arrow_drop_up else R.drawable.ic_arrow_drop_down
                        ),
                        contentDescription = null,
                        tint = if (!enabled) SwapColor.gray450 else SwapColor.gray900
                    )
                }

                DropdownMenu(
                    expanded = expanded,
                    onDismissRequest = { expanded = false }
                ) {
                    options.forEach { option ->
                        DropdownMenuItem(
                            text = {
                                Text(
                                    text = option,
                                    style = SwapTypography.BodyLarge,
                                    color = if (!enabled) SwapColor.gray450 else SwapColor.gray900
                                )
                            },
                            onClick = {
                                onOptionSelected(option)
                                expanded = false
                            },
                            enabled = enabled
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SwapSelectFieldPreview() {
    Column(
        modifier = Modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        SwapSelectField.Select(
            selectedOption = null,
            onOptionSelected = {},
            label = "title",
            placeholder = "Option",
            isActive = true
        )

        SwapSelectField.Select(
            selectedOption = "Option 1",
            onOptionSelected = {},
            label = "title",
            isActive = true
        )

        SwapSelectField.Select(
            selectedOption = "Option 1",
            onOptionSelected = {},
            label = "title",
            isError = true
        )

        SwapSelectField.Select(
            selectedOption = "Option 1",
            onOptionSelected = {},
            label = "title",
            enabled = false
        )
    }
}
