package com.uiel.swap.ui.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonColors
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
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
import com.uiel.swap.design_system.clickable
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
            .padding(
                horizontal = 24.dp,
                vertical = 20.dp,
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Image(
            painter = painterResource(id = SwapIcon.Logo),
            contentDescription = null,
        )
        Spacer(modifier = Modifier.weight(1f))
        IconButton(
            onClick = { /*TODO*/ },
            colors = IconButtonColors(
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
            .clip(
                RoundedCornerShape(
                    topStart = 20.dp,
                    topEnd = 20.dp,
                )
            )
            .background(SwapColor.main500),
        horizontalArrangement = Arrangement.spacedBy(12.dp),
    ) {
        Column(
            modifier = Modifier
                .padding(
                    start = 24.dp,
                    top = 24.dp,
                    bottom = 24.dp,
                ),
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
            modifier = Modifier.padding(
                top = 12.dp,
                end = 8.dp,
                bottom = 14.dp,
            ),
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
            .clip(
                RoundedCornerShape(
                    topStart = 20.dp,
                    topEnd = 20.dp,
                )
            )
            .background(SwapColor.background),
    ) {
        val bike = listOf("전체", "어반바이크", "킥스쿠터", "브랜드 콜라보", "자토바이", "로드바이크", "카고바이크")
        val focus = remember { mutableIntStateOf(0) }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 16.dp)
                .horizontalScroll(rememberScrollState()),
            horizontalArrangement = Arrangement.spacedBy(24.dp),
        ) {
            Spacer(modifier = Modifier.width(8.dp))
            bike.forEachIndexed { index, s ->
                Column(
                    modifier = Modifier.clickable(
                        onClick = { focus.intValue = index }
                    ),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {
                    Spacer(modifier = Modifier.height(8.dp))
                    SwapText(
                        text = s,
                        style = if (focus.intValue == index) SwapTypography.TitleMedium else SwapTypography.BodyLarge,
                        color = if (focus.intValue == index) Color.Black else SwapColor.gray600
                    )
                    if (focus.intValue == index) {
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
                    .background(
                        shape = RoundedCornerShape(50.dp),
                        color = Color.White,
                    )
                    .padding(
                        start = 12.dp,
                        top = 4.dp,
                        bottom = 4.dp,
                        end = 8.dp,
                    )
                    .clickable(
                        onClick = { }
                    ),
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
            FilterButton(
                text = "컬러",
                onClick = { },
            )
            FilterButton(
                text = "가격대",
                onClick = { },
            )
            FilterButton(
                text = "기기 스펙",
                onClick = { },
            )
        }
    }
}

@Composable
private fun FilterButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
) {
    SwapText(
        modifier = Modifier
            .background(
                shape = RoundedCornerShape(50.dp),
                color = Color.White,
            )
            .padding(
                horizontal = 12.dp,
                vertical = 6.dp,
            )
            .clickable(
                onClick = onClick,
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
) {
    Box(
        modifier = Modifier
            .padding(16.dp)
            .background(
                shape = RoundedCornerShape(16.dp),
                color = SwapColor.gray0,
            ),
        contentAlignment = Alignment.TopCenter,
    ) {
        SwapText(
            text = title,
            style = SwapTypography.BodyMedium
        )
        Spacer(modifier = Modifier.height(4.dp))
        SwapText(
            text = price,
            style = SwapTypography.BodySmall,
        )
    }
}