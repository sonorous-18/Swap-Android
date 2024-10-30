package com.uiel.swap.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.uiel.swap.R
import com.uiel.swap.design_system.SwapColor
import com.uiel.swap.design_system.SwapIcon
import com.uiel.swap.design_system.SwapText
import com.uiel.swap.design_system.SwapTypography
import com.uiel.swap.ui.home.bottomsheet.FilterBottomSheet
import com.uiel.swap.ui.home.bottomsheet.FilterType
import com.uiel.swap.viewmodel.home.HomeViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel(),
    navController: NavController
) {
    var showFilterSheet by remember { mutableStateOf(false) }
    var currentFilterType by remember { mutableStateOf(FilterType.COLOR) }
    var selectedItems by remember { mutableStateOf(listOf<String>()) }

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
                Content(
                    onFilterButtonClick = { filterType ->
                        currentFilterType = filterType
                        showFilterSheet = true
                    },
                    navController = navController
                )
            }
        }
    }

    FilterBottomSheet(
        showSheet = showFilterSheet,
        currentType = currentFilterType,
        onTypeChange = { currentFilterType = it },
        onDismiss = { showFilterSheet = false },
        selectedItems = selectedItems,
        onItemSelected = { selectedItems = selectedItems + it },
        onItemDeselected = { selectedItems = selectedItems - it }
    )
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
    modifier: Modifier = Modifier,
    onFilterButtonClick: (FilterType) -> Unit,
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
            .background(SwapColor.background),
    ) {
        val bikeCategories = listOf("전체", "어반바이크", "킥스쿠터", "브랜드 콜라보", "자토바이", "로드바이크", "카고바이크")
        val selectedCategory = remember { mutableStateOf(0) }
        val listState = rememberLazyListState()

        LaunchedEffect(selectedCategory.value) {
            listState.animateScrollToItem(selectedCategory.value)
        }

        LazyRow(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp),
            state = listState,
            contentPadding = PaddingValues(horizontal = 24.dp),
            horizontalArrangement = Arrangement.spacedBy(24.dp),
        ) {
            items(bikeCategories.size) { index ->
                Column(
                    modifier = Modifier.clickable(
                        interactionSource = remember { MutableInteractionSource() },
                        indication = null,
                        onClick = { selectedCategory.value = index },
                    ),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Spacer(modifier = Modifier.height(8.dp))
                    SwapText(
                        text = bikeCategories[index],
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

            FilterButton(text = "컬러") { onFilterButtonClick(FilterType.COLOR) }
            FilterButton(text = "가격대") { onFilterButtonClick(FilterType.PRICE) }
            FilterButton(text = "기기 스펙") { onFilterButtonClick(FilterType.SPEC) }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
                .padding(horizontal = 24.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            for (i in 1..15) {
                Product(
                    title = "자이언트 에스케이프 디스크 2 하이브리드",
                    price = "월 15,000원 ~",
                    productId = 1,
                    navController = navController
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
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
            .clickable(
                onClick = onClick,
                interactionSource = remember { MutableInteractionSource() },
                indication = null
            ),
        text = text,
        style = SwapTypography.BodyMedium,
        color = SwapColor.gray800,
    )
}

@Composable
private fun Product(
    modifier: Modifier = Modifier,
    title: String,
    price: String,
    productId: Long,
    navController: NavController
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .background(Color.White)
            .clickable {
                navController.navigate("subscribeDetailScreen/$productId")
            }
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
                .clip(RoundedCornerShape(topStart = 12.dp, topEnd = 12.dp))
                .background(SwapColor.background)
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp),
                painter = painterResource(id = R.drawable.ic_product_back),
                contentDescription = null,
                contentScale = ContentScale.Crop,
            )
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column {
                SwapText(
                    modifier = Modifier.widthIn(max = 180.dp),
                    text = title,
                    style = SwapTypography.BodyMedium,
                    color = Color.Black,
                    maxLines = 2,
                )
                Spacer(modifier = Modifier.height(4.dp))
                SwapText(
                    text = price,
                    style = SwapTypography.BodySmall,
                    color = SwapColor.gray600,
                )
                Row(
                    modifier = Modifier.padding(top = 8.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .size(16.dp)
                            .background(
                                shape = CircleShape,
                                color = SwapColor.main700,
                            )
                    )
                    Box(
                        modifier = Modifier
                            .size(16.dp)
                            .background(
                                shape = CircleShape,
                                color = SwapColor.gray450,
                            )
                    )
                }
            }

            Image(
                modifier = Modifier
                    .size(100.dp)
                    .padding(start = 16.dp),
                painter = painterResource(id = R.drawable.img_kickboard),
                contentDescription = null,
                contentScale = ContentScale.Fit
            )
        }
    }
}