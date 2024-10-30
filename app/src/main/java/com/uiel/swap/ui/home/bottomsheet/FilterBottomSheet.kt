package com.uiel.swap.ui.home.bottomsheet

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uiel.swap.design_system.SwapColor
import com.uiel.swap.design_system.SwapTypography
import com.uiel.swap.design_system.button.SwapOutlineButton
import com.uiel.swap.design_system.button.SwapTextButton
import com.uiel.swap.viewmodel.home.HomeViewModel

enum class FilterType {
    COLOR, PRICE, SPEC
}

sealed class FilterOption(val name: String) {
    data class ColorOption(
        val colorName: String,
        val color: Color,
        val isSelected: Boolean = false
    ) : FilterOption(colorName)

    data class PriceOption(
        val priceName: String,
        val isSelected: Boolean = false
    ) : FilterOption(priceName)

    data class SpecOption(
        val specName: String,
        val isSelected: Boolean = false
    ) : FilterOption(specName)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FilterBottomSheet(
    showSheet: Boolean,
    currentType: FilterType,
    onTypeChange: (FilterType) -> Unit,
    onDismiss: () -> Unit,
    selectedItems: List<String>,
    onItemSelected: (String) -> Unit,
    onItemDeselected: (String) -> Unit,
    itemCount: Int = 123,
    viewModel: HomeViewModel,
) {
    val colorOptions = listOf(
        FilterOption.ColorOption("Cream", Color(0xFFFFFBF0)),
        FilterOption.ColorOption("Pink", Color(0xFFFFB6C1)),
        FilterOption.ColorOption("Silver", Color(0xFFC0C0C0)),
        FilterOption.ColorOption("Black", Color(0xFF000000)),
        FilterOption.ColorOption("Red", Color(0xFFFF0000)),
        FilterOption.ColorOption("Green", Color(0xFF008000)),
        FilterOption.ColorOption("Blue", Color(0xFF0000FF)),
        FilterOption.ColorOption("Grey", Color(0xFF808080)),
        FilterOption.ColorOption("Purple", Color(0xFF800080)),
        FilterOption.ColorOption("Beige", Color(0xFFF5F5DC)),
        FilterOption.ColorOption("Sky Blue", Color(0xFF87CEEB)),
        FilterOption.ColorOption("White", Color(0xFFFFFFFF))
    ).map { it.copy(isSelected = selectedItems.contains(it.name)) }

    val priceOptions = listOf(
        FilterOption.PriceOption("월 1-2만원대"),
        FilterOption.PriceOption("월 3-4만원대"),
        FilterOption.PriceOption("월 5만원 이상")
    ).map { it.copy(isSelected = selectedItems.contains(it.name)) }

    val specOptions = listOf(
        FilterOption.SpecOption("PAS"),
        FilterOption.SpecOption("스로틀"),
        FilterOption.SpecOption("PAS+스로틀"),
        FilterOption.SpecOption("무동력")
    ).map { it.copy(isSelected = selectedItems.contains(it.name)) }

    if (showSheet) {
        ModalBottomSheet(
            onDismissRequest = onDismiss,
            containerColor = Color.White,
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 10.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    TabButton("컬러", currentType == FilterType.COLOR) {
                        onTypeChange(FilterType.COLOR)
                    }
                    TabButton("가격대", currentType == FilterType.PRICE) {
                        onTypeChange(FilterType.PRICE)
                    }
                    TabButton("기기스펙", currentType == FilterType.SPEC) {
                        onTypeChange(FilterType.SPEC)
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                when (currentType) {
                    FilterType.COLOR -> {
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(2),
                            horizontalArrangement = Arrangement.spacedBy(12.dp),
                            verticalArrangement = Arrangement.spacedBy(12.dp),
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            items(colorOptions) { option ->
                                ColorOptionButton(
                                    option = option,
                                    onClick = {
                                        if (option.isSelected) {
                                            onItemDeselected(option.name)
                                        } else {
                                            onItemSelected(option.name)
                                        }
                                        //viewModel.updateColors(option.name)
                                    }
                                )
                            }
                        }
                    }
                    FilterType.PRICE -> {
                        priceOptions.forEach { option ->
                            CheckboxOptionButton(
                                text = option.name,
                                isChecked = option.isSelected,
                                onCheckedChange = { isChecked ->
                                    if (isChecked) onItemSelected(option.name)
                                    else onItemDeselected(option.name)
                                }
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                    }
                    FilterType.SPEC -> {
                        specOptions.forEach { option ->
                            CheckboxOptionButton(
                                text = option.name,
                                isChecked = option.isSelected,
                                onCheckedChange = { isChecked ->
                                    if (isChecked) onItemSelected(option.name)
                                    else onItemDeselected(option.name)
                                }
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    selectedItems.forEach { itemName ->
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .background(
                                    color = SwapColor.gray100,
                                    shape = RoundedCornerShape(4.dp)
                                )
                                .padding(horizontal = 8.dp, vertical = 4.dp)
                        ) {
                            Text(
                                text = itemName,
                                style = SwapTypography.BodySmall,
                                color = SwapColor.gray900
                            )
                            Spacer(modifier = Modifier.width(4.dp))
                            Text(
                                text = "×",
                                style = SwapTypography.BodySmall,
                                color = SwapColor.gray900,
                                modifier = Modifier.clickable {
                                    onItemDeselected(itemName)
                                }
                            )
                        }
                    }
                }

                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    SwapOutlineButton(
                        text = "초기화",
                        onClick = { selectedItems.forEach { onItemDeselected(it) } },
                        modifier = Modifier.weight(1f),
                        small = false,
                        enabled = true,
                        keyboardInteractionEnabled = true
                    )
                    SwapTextButton(
                        text = "${itemCount}개 상품 보기",
                        onClick = { selectedItems.forEach { onItemDeselected(it) } },
                        modifier = Modifier.weight(1f),
                        small = false,
                        enabled = true,
                        keyboardInteractionEnabled = true
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))
            }
        }
    }
}

@Composable
private fun CheckboxOptionButton(
    text: String,
    isChecked: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clip(RoundedCornerShape(8.dp))
            .clickable { onCheckedChange(!isChecked) }
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Checkbox(
            checked = isChecked,
            onCheckedChange = onCheckedChange,
            colors = CheckboxDefaults.colors(
                checkedColor = SwapColor.main500,
                uncheckedColor = SwapColor.gray200
            )
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = text,
            style = SwapTypography.BodyMedium,
            color = SwapColor.gray900
        )
    }
}

@Composable
private fun TabButton(
    text: String,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.clickable(onClick = onClick)
    ) {
        Text(
            text = text,
            style = SwapTypography.TitleLarge,
            color = if (isSelected) SwapColor.gray900 else SwapColor.gray450,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
        if (isSelected) {
            Spacer(modifier = Modifier.height(4.dp))
            Box(
                modifier = Modifier
                    .size(4.dp)
                    .clip(CircleShape)
                    .background(Color.Black)
            )
        }
    }
}

@Composable
private fun ColorOptionButton(
    option: FilterOption.ColorOption,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(56.dp)
            .clip(RoundedCornerShape(24.dp))
            .background(
                if (option.isSelected) SwapColor.main500.copy(alpha = 0.1f)
                else Color.White
            )
            .border(
                width = 1.dp,
                color = if (option.isSelected) SwapColor.main500
                else SwapColor.gray200,
                shape = RoundedCornerShape(24.dp)
            )
            .clickable(onClick = onClick)
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Box(
            modifier = Modifier
                .size(24.dp)
                .clip(CircleShape)
                .background(option.color)
                .border(
                    width = 1.dp,
                    color = SwapColor.gray200,
                    shape = CircleShape
                )
        )
        Spacer(modifier = Modifier.width(12.dp))
        Text(
            text = option.name,
            style = SwapTypography.BodyMedium,
            color = SwapColor.gray900
        )
    }
}

//@Composable
//private fun SimpleOptionButton(
//    option: FilterOption,
//    onClick: () -> Unit
//) {
//    val isSelected = when (option) {
//        is FilterOption.ColorOption -> option.isSelected
//        is FilterOption.PriceOption -> option.isSelected
//        is FilterOption.SpecOption -> option.isSelected
//    }
//
//    Row(
//        modifier = Modifier
//            .fillMaxWidth()
//            .height(56.dp)
//            .clip(RoundedCornerShape(24.dp))
//            .background(
//                if (isSelected) SwapColor.main500.copy(alpha = 0.1f)
//                else Color.White
//            )
//            .border(
//                width = 1.dp,
//                color = if (isSelected) SwapColor.main500
//                else SwapColor.gray200,
//                shape = RoundedCornerShape(24.dp)
//            )
//            .clickable(onClick = onClick)
//            .padding(horizontal = 16.dp),
//        verticalAlignment = Alignment.CenterVertically
//    ) {
//        Text(
//            text = option.name,
//            style = SwapTypography.BodyMedium,
//            color = SwapColor.gray900
//        )
//    }
//}
