package com.uiel.swap.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.uiel.swap.R
import com.uiel.swap.design_system.SwapColor
import com.uiel.swap.design_system.SwapIcon
import com.uiel.swap.design_system.SwapText
import com.uiel.swap.design_system.SwapTypography
import com.uiel.swap.design_system.button.SwapOutlineButton
import com.uiel.swap.viewmodel.home.HomeViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel()
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(SwapColor.gray0),
    ) {
        TopBar()
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(rememberScrollState()),
        ) {
            Banner()
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(SwapColor.main500)
            ) {
                Content()
            }
        }
    }
}

@Composable
private fun TopBar(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp, vertical = 20.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(id = SwapIcon.Logo),
            contentDescription = null,
        )
        Spacer(modifier = Modifier.weight(1f))
        IconButton(
            onClick = { /*TODO*/ },
            colors = IconButtonDefaults.iconButtonColors(
                containerColor = SwapColor.main500,
                contentColor = SwapColor.gray0,
                disabledContentColor = SwapColor.main500,
                disabledContainerColor = SwapColor.gray0,
            )
        ) {
            Image(
                painter = painterResource(id = SwapIcon.Search),
                contentDescription = null,
            )
        }
    }
}

@Composable
private fun Banner(
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
            .background(SwapColor.main500),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Column(
            modifier = Modifier
                .padding(start = 24.dp, top = 24.dp, bottom = 24.dp),
            verticalArrangement = Arrangement.spacedBy(4.dp),
        ) {
            SwapText(
                text = "수리 걱정 없이, 간편하게\n다양한 자전거를 이용할 수 있어요",
                style = SwapTypography.TitleLarge,
                color = SwapColor.gray0,
            )
            SwapText(
                text = "한 달 동안 무료로 사용해보세요",
                style = SwapTypography.BodyMedium,
                color = SwapColor.gray100,
            )
        }
        Spacer(modifier = Modifier.weight(1f))
        Image(
            modifier = Modifier.padding(top = 12.dp, end = 8.dp, bottom = 14.dp),
            painter = painterResource(id = SwapIcon.Character),
            contentDescription = null,
        )
    }
}

@Composable
private fun Content(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
            .background(SwapColor.background),
    ) {
        val bikeCategories = listOf("전체", "어반바이크", "킥스쿠터", "브랜드 콜라보", "자토바이", "로드바이크", "카고바이크")
        val selectedCategory = remember { mutableStateOf(0) }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(24.dp),
        ) {
            Spacer(modifier = Modifier.width(8.dp))
            bikeCategories.forEachIndexed { index, category ->
                Column(
                    modifier = Modifier.clickable(onClick = { selectedCategory.value = index }),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Spacer(modifier = Modifier.height(8.dp))
                    SwapText(
                        text = category,
                        style = if (selectedCategory.value == index) SwapTypography.TitleMedium else SwapTypography.BodyLarge,
                        color = if (selectedCategory.value == index) Color.Black else SwapColor.gray600
                    )
                    if (selectedCategory.value == index) {
                        Box(
                            modifier = Modifier
                                .size(8.dp)
                                .clip(CircleShape)
                                .background(Color.Black),
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp)
                .padding(horizontal = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp),
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Row(
                modifier = Modifier
                    .background(Color.White, RoundedCornerShape(50.dp))
                    .padding(start = 12.dp, top = 4.dp, bottom = 4.dp, end = 8.dp)
                    .clickable(onClick = {}),
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                SwapText(
                    text = "인기순",
                    style = SwapTypography.BodyMedium,
                    color = SwapColor.gray800,
                )
                Spacer(modifier = Modifier.width(4.dp))
                Icon(
                    painter = painterResource(id = SwapIcon.Down),
                    contentDescription = null,
                )
            }
            FilterButton(text = "컬러", onClick = {})
            FilterButton(text = "가격대", onClick = {})
            FilterButton(text = "기기 스펙", onClick = {})
        }
    }
}

@Composable
private fun FilterButton(
    text: String,
    onClick: () -> Unit,
) {
    SwapText(
        modifier = Modifier
            .background(Color.White, RoundedCornerShape(50.dp))
            .padding(horizontal = 12.dp, vertical = 6.dp)
            .clickable(onClick = onClick),
        text = text,
        style = SwapTypography.BodyMedium,
        color = SwapColor.gray800,
    )
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

                Divider(
                    color = SwapColor.gray300,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 16.dp)
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
