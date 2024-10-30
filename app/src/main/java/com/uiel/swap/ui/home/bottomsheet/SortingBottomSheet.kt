package com.uiel.swap.ui.home.bottomsheet

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uiel.swap.R
import com.uiel.swap.design_system.SwapColor
import com.uiel.swap.design_system.SwapTypography
import com.uiel.swap.design_system.button.SwapOutlineButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SortingBottomSheet(
    showSheet: Boolean,
    onDismiss: () -> Unit,
    onSortOptionSelected: (SortOption) -> Unit
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
                    text = "정렬",
                    style = SwapTypography.TitleLarge,
                    color = SwapColor.gray900,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                SortOptionButton(text = "인기순", icon = R.drawable.ic_star) {
                    onSortOptionSelected(SortOption.POPULARITY)
                    onDismiss()
                }
                SortOptionButton(text = "높은 가격순", icon = R.drawable.ic_high_price) {
                    onSortOptionSelected(SortOption.PRICE_HIGH)
                    onDismiss()
                }
                SortOptionButton(text = "낮은 가격순", icon = R.drawable.ic_low_price) {
                    onSortOptionSelected(SortOption.PRICE_LOW)
                    onDismiss()
                }
                Spacer(modifier = Modifier.height(32.dp))
                SwapOutlineButton(
                    text = "닫기",
                    onClick = onDismiss,
                    modifier = Modifier.fillMaxWidth(),
                    small = false,
                    enabled = true,
                    keyboardInteractionEnabled = true
                )
                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
private fun SortOptionButton(
    text: String,
    icon: Int,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 4.dp)
            .clickable(onClick = onClick),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = null,
            tint = Color.Unspecified
        )
        Spacer(modifier = Modifier.width(8.dp))
        Text(
            text = text,
            style = SwapTypography.TitleMedium,
        )
    }
}

enum class SortOption {
    POPULARITY,
    PRICE_HIGH,
    PRICE_LOW
}

@Preview(showBackground = true)
@Composable
fun SortingBottomSheetPreview() {
    SortingBottomSheet(
        showSheet = true,
        onDismiss = {},
        onSortOptionSelected = {}
    )
}