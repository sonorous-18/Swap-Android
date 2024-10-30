package com.uiel.swap.ui.home.bottomsheet

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ExperimentalLayoutApi
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uiel.swap.design_system.SwapColor
import com.uiel.swap.design_system.SwapTypography

@OptIn(ExperimentalMaterial3Api::class, ExperimentalLayoutApi::class)
@Composable
fun ColorSelectionBottomSheet(
    showSheet: Boolean,
    selectedColors: List<String>,
    onDismiss: () -> Unit,
    onColorSelected: (String) -> Unit,
    onColorCleared: () -> Unit,
    onViewItems: () -> Unit
) {
    if (showSheet) {
        ModalBottomSheet(
            onDismissRequest = onDismiss,
            containerColor = Color.White
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 10.dp)
            ) {
                Text(
                    text = "컬러",
                    style = SwapTypography.TitleLarge,
                    color = SwapColor.gray900,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                val colors = listOf("Cream", "Pink", "Silver", "Black", "Red", "Green",
                    "Blue", "Gray", "Purple", "Beige", "Sky Blue", "White")

                FlowRow(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp),
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    colors.forEach { color ->
                        Box(
                            modifier = Modifier
                                .border(
                                    width = 2.dp,
                                    color = if (color in selectedColors) SwapColor.main500 else SwapColor.gray600,
                                    shape = RoundedCornerShape(24.dp)
                                )
                                .background(getColorFromName(color), CircleShape)
                                .size(50.dp)
                                .clickable { onColorSelected(color) },
                            contentAlignment = Alignment.Center
                        ) {
                            Text(
                                text = color,
                                style = SwapTypography.BodySmall,
                                color = Color.Black
                            )
                        }
                    }
                }

                HorizontalDivider(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp),
                    color = SwapColor.gray300
                )

                if (selectedColors.isNotEmpty()) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp)
                    ) {
                        Icon(
                            imageVector = Icons.Default.Clear,
                            contentDescription = null,
                            tint = Color.Black,
                            modifier = Modifier.clickable { onColorCleared() }
                        )
                        Spacer(modifier = Modifier.width(8.dp))
                        Text(
                            text = selectedColors.joinToString(", "),
                            style = SwapTypography.BodyMedium,
                            color = Color.Black
                        )
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    Button(
                        onClick = onColorCleared,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = SwapColor.gray200,
                            contentColor = SwapColor.gray600
                        ),
                        modifier = Modifier.weight(0.4f)
                    ) {
                        Text("초기화")
                    }

                    Button(
                        onClick = onViewItems,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = SwapColor.main500,
                            contentColor = Color.White
                        ),
                        modifier = Modifier.weight(0.6f)
                    ) {
                        Text("123개 상품 보기")
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
fun getColorFromName(colorName: String): Color {
    return when (colorName) {
        "Cream" -> Color(0xFFF5F5DC)
        "Pink" -> Color(0xFFFFC0CB)
        "Silver" -> Color(0xFFC0C0C0)
        "Black" -> Color.Black
        "Red" -> Color.Red
        "Green" -> Color.Green
        "Blue" -> Color.Blue
        "Gray" -> Color.Gray
        "Purple" -> Color(0xFF800080)
        "Beige" -> Color(0xFFF5F5DC)
        "Sky Blue" -> Color(0xFF87CEEB)
        "White" -> Color.White
        else -> Color.Transparent
    }
}

@Preview(showBackground = true)
@Composable
fun ColorSelectionBottomSheetPreview() {
    val selectedColors = remember { mutableStateListOf<String>() }

    ColorSelectionBottomSheet(
        showSheet = true,
        selectedColors = selectedColors,
        onDismiss = {},
        onColorSelected = { color ->
            if (selectedColors.contains(color)) {
                selectedColors.remove(color)
            } else {
                selectedColors.add(color)
            }
        },
        onColorCleared = { selectedColors.clear() },
        onViewItems = {}
    )
}
