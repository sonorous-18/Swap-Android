package com.uiel.swap.ui.home

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.widthIn
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
import coil3.compose.AsyncImage
import com.uiel.swap.R
import com.uiel.swap.design_system.SwapColor
import com.uiel.swap.design_system.SwapIcon
import com.uiel.swap.design_system.SwapText
import com.uiel.swap.design_system.SwapTypography
import com.uiel.swap.model.SubscribeProductListResponse
import com.uiel.swap.ui.home.bottomsheet.FilterBottomSheet
import com.uiel.swap.ui.home.bottomsheet.FilterType
import com.uiel.swap.viewmodel.home.HomeViewModel

@Composable
fun HomeScreen(
    viewModel: HomeViewModel = viewModel()
) {
    var showFilterSheet by remember { mutableStateOf(false) }
    var currentFilterType by remember { mutableStateOf(FilterType.COLOR) }
    var selectedItems by remember { mutableStateOf(listOf<String>()) }

    val uiState by viewModel.uiState.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.getSub()
    }

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
                    subList = uiState.sub,
                )
            }
        }
    }

    FilterBottomSheet(
        showSheet = showFilterSheet,
        currentType = currentFilterType,
        onTypeChange = {
            currentFilterType = it
        },
        onDismiss = { showFilterSheet = false },
        selectedItems = selectedItems,
        onItemSelected = { selectedItems = selectedItems + it },
        onItemDeselected = { selectedItems = selectedItems - it },
        viewModel = viewModel,
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
    subList: List<SubscribeProductListResponse>,
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

            FilterButton(text = "컬러") { onFilterButtonClick(FilterType.COLOR) }
            FilterButton(text = "가격대") { onFilterButtonClick(FilterType.PRICE) }
            FilterButton(text = "기기 스펙") { onFilterButtonClick(FilterType.SPEC) }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp)
                .padding(horizontal = 24.dp),
            //verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            subList.forEach {
                Product(
                    title = it.title,
                    price = "월 ${it.price}원 ~",
                    img = it.thumbnail,
                    colors = it.colors,
                )
            }
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

@Composable
private fun Product(
    modifier: Modifier = Modifier,
    title: String,
    price: String,
    img: String,
    colors: List<com.uiel.swap.model.Color>,
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .height(150.dp)
            .clip(RoundedCornerShape(12.dp))
    ) {

        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp),
            painter = painterResource(id = R.drawable.ic_product_back),
            contentDescription = null,
            contentScale = ContentScale.FillWidth,
        )

        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    start = 16.dp,
                    top = 16.dp,
                    bottom = 16.dp,
                ),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column(
                modifier = Modifier
                //.fillMaxHeight()
            ) {
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
                    modifier = Modifier.padding(top = 40.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    colors.forEach {
                        val color = when (it) {
                            com.uiel.swap.model.Color.CREAM -> Color(0xFFF3F0E5)
                            com.uiel.swap.model.Color.PINK -> Color(0xFFF08CB0)
                            com.uiel.swap.model.Color.SILVER -> Color(0xFFC3C3C3)
                            com.uiel.swap.model.Color.BLACK -> Color(0xFF383838)
                            com.uiel.swap.model.Color.RED -> Color(0xFFDE5151)
                            com.uiel.swap.model.Color.GREEN -> Color(0xFF5D8F63)
                            com.uiel.swap.model.Color.BLUE -> Color(0xFF6C85DA)
                            com.uiel.swap.model.Color.GREY -> Color(0xFF737373)
                            com.uiel.swap.model.Color.PURPLE -> Color(0xFFA475DF)
                            com.uiel.swap.model.Color.BEIGE -> Color(0xFFFAE7BC)
                            com.uiel.swap.model.Color.SKY_BLUE -> Color(0xFF6CB1DF)
                            com.uiel.swap.model.Color.WHITE -> Color(0xFFFFFFFF)
                        }
                        if (it == com.uiel.swap.model.Color.WHITE) {
                            Box(
                                modifier = Modifier
                                    .size(16.dp)
                                    .border(1.dp, Color(0xFFE2E2E2), CircleShape)
                                    .background(
                                        shape = CircleShape,
                                        color = color,
                                    )
                            )
                        } else {
                            Box(
                                modifier = Modifier
                                    .size(16.dp)
                                    .background(
                                        shape = CircleShape,
                                        color = color,
                                    )
                            )
                        }
                    }
                }
            }
            Spacer(modifier = Modifier.weight(1f))
            AsyncImage(
                modifier = Modifier
                    .size(140.dp),
                model = img,
                contentDescription = null,
            )
        }
    }
}