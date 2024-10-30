package com.uiel.swap.ui.subscribe

import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.uiel.swap.design_system.SwapColor
import com.uiel.swap.design_system.SwapTypography
import com.uiel.swap.design_system.button.SwapColoredButton

@Composable
fun SubscribeDetailScreen() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(SwapColor.gray0)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 80.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                IconButton(onClick = { /* 뒤로가기 버튼 */ }) {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null,
                        tint = SwapColor.gray800
                    )
                }
                Text(
                    text = "Ace",
                    style = SwapTypography.TitleLarge,
                    color = SwapColor.gray800
                )
            }

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .background(SwapColor.gray200)
            ) {
                Text(
                    text = "Image Carousel",
                    modifier = Modifier.align(Alignment.Center),
                    style = SwapTypography.BodyMedium,
                    color = SwapColor.gray450
                )
                Box(
                    modifier = Modifier
                        .align(Alignment.BottomCenter)
                        .padding(16.dp)
                        .shadow(4.dp, CircleShape)
                        .background(SwapColor.gray0, RoundedCornerShape(24.dp))
                        .padding(horizontal = 16.dp, vertical = 12.dp)
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                    ) {
                        Text(
                            text = "Midnight Black",
                            style = SwapTypography.BodyLarge,
                            color = SwapColor.gray800
                        )
                        Spacer(modifier = Modifier.width(50.dp))
                        Row(horizontalArrangement = Arrangement.spacedBy(8.dp)) {
                            Box(modifier = Modifier.size(24.dp).background(SwapColor.gray900, CircleShape))
                            Box(modifier = Modifier.size(24.dp).background(SwapColor.gray600, CircleShape))
                            Box(modifier = Modifier.size(24.dp).background(SwapColor.main300, CircleShape))
                            Box(modifier = Modifier.size(24.dp).background(SwapColor.gray200, CircleShape))
                        }
                    }
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp)
            ) {
                Text(text = "어반바이크", style = SwapTypography.BodyLarge, color = SwapColor.gray600)
                Spacer(modifier = Modifier.height(8.dp))
                Text(text = "Ace", style = SwapTypography.HeadlineSmall, color = SwapColor.gray800)
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "월 구독료", style = SwapTypography.BodyMedium, color = SwapColor.gray600)
                    Text(text = "15,000원", style = SwapTypography.TitleMedium, color = SwapColor.gray800)
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(text = "배송 정보", style = SwapTypography.BodyMedium, color = SwapColor.gray600)
                    Text(text = "11/06 이후 5영업일 이내 순차 배송", style = SwapTypography.BodyMedium, color = SwapColor.gray800)
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "비대면 영업배송",
                        style = SwapTypography.TitleSmall,
                        color = SwapColor.main500
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState())
                        .padding(bottom = 16.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    repeat(2) {
                        Column(
                            modifier = Modifier
                                .width(200.dp)
                                .border(1.dp, SwapColor.gray300, RoundedCornerShape(12.dp))
                                .padding(12.dp)
                        ) {
                            Text(text = "홍길동", style = SwapTypography.BodyLarge, color = SwapColor.gray800)
                            Spacer(modifier = Modifier.height(8.dp))
                            Text(text = "리뷰 예시 내용입니다.", style = SwapTypography.BodyMedium, color = SwapColor.gray600)
                        }
                    }
                }
            }
        }

        SwapColoredButton(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
                .align(Alignment.BottomCenter)
                .padding(bottom = 20.dp),
            text = "이용하기",
            onClick = {},
            small = false,
        )
    }
}



@Preview(showBackground = true)
@Composable
fun SubscribeDetailScreenPreview() {
    SubscribeDetailScreen()
}
