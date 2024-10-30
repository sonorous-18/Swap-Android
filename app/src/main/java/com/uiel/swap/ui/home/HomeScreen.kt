package com.uiel.swap.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.uiel.swap.design_system.SwapColor
import com.uiel.swap.design_system.SwapIcon
import com.uiel.swap.design_system.SwapText
import com.uiel.swap.design_system.SwapTypography
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