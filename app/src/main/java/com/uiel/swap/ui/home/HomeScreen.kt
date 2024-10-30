package com.uiel.swap.ui.home

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
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
import com.uiel.swap.design_system.clickable
import com.uiel.swap.viewmodel.home.HomeViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "홈",
            style = MaterialTheme.typography.headlineMedium,
            color = MaterialTheme.colorScheme.primary
        )
    }
}

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

                SortOptionButton(
                    text = "인기순",
                    icon = R.drawable.ic_star,
                    onClick = {
                        onSortOptionSelected(SortOption.POPULARITY)
                        onDismiss()
                    }
                )

                SortOptionButton(
                    text = "높은 가격순",
                    icon = R.drawable.ic_high_price,
                    onClick = {
                        onSortOptionSelected(SortOption.PRICE_HIGH)
                        onDismiss()
                    }
                )

                SortOptionButton(
                    text = "낮은 가격순",
                    icon = R.drawable.ic_low_price,
                    onClick = {
                        onSortOptionSelected(SortOption.PRICE_LOW)
                        onDismiss()
                    }
                )

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
