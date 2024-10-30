package com.uiel.swap.ui.mypage

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uiel.swap.R
import com.uiel.swap.design_system.SwapColor
import com.uiel.swap.design_system.SwapText
import com.uiel.swap.design_system.SwapTypography
import com.uiel.swap.design_system.clickable

@Composable
fun MyPageScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(SwapColor.background)
    ) {
        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(fontSize = 32.sp)) {
                    append("홍길동")
                }
                withStyle(style = SpanStyle(fontSize = 24.sp, fontWeight = FontWeight.SemiBold)) {
                    append(" 님")
                }
            },
            style = SwapTypography.HeadlineLarge,
            modifier = Modifier.padding(start = 28.dp, top = 32.dp, bottom = 20.dp),
            color = Color.Black,
        )

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "내 자전거 등록",
                        style = SwapTypography.HeadlineSmall.copy(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold
                        ),
                        color = Color.Black,
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_right),
                        contentDescription = "더보기",
                        tint = SwapColor.gray300,
                    )
                }

                // Padding between the title row and the counts row
                Spacer(modifier = Modifier.height(8.dp))

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceEvenly,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    BicycleCount("등록한 수", "3대")
                    VerticalDivider()
                    BicycleCount("대여중", "1대")
                    VerticalDivider()
                    BicycleCount("관리중", "2대")
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

        Card(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            shape = RoundedCornerShape(20.dp)
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "구독관리",
                        style = SwapTypography.TitleLarge.copy(
                            fontSize = 18.sp,
                            fontWeight = FontWeight.SemiBold
                        ),
                        color = Color.Black,
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.ic_arrow_right),
                        contentDescription = "더보기",
                        tint = SwapColor.gray300,
                    )
                }

                Image(
                    painter = painterResource(id = R.drawable.img_bicycle),
                    contentDescription = "자전거 이미지",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(120.dp)
                        .padding(vertical = 8.dp),
                    contentScale = ContentScale.Fit
                )

                Text(
                    text = "자이언트 에스케이프 디스크 2 하이브리드",
                    style = SwapTypography.TitleMedium,
                    color = SwapColor.gray900,
                )

                Text(
                    text = "120일째 이용중",
                    style = SwapTypography.BodyMedium,
                    color = SwapColor.gray600,
                    modifier = Modifier.padding(top = 4.dp)
                )

                HorizontalDivider(
                    modifier = Modifier.padding(vertical = 12.dp),
                    thickness = 1.dp,
                    color = SwapColor.gray200,
                )

                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Text(
                        text = "다음 갱신일",
                        style = SwapTypography.BodyMedium,
                        color = SwapColor.gray600,
                    )
                    Text(
                        text = "2024.11.30",
                        style = SwapTypography.BodyMedium,
                        fontWeight = FontWeight.Medium,
                        color = SwapColor.gray600,
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(8.dp))

//        Row(
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(horizontal = 20.dp),
//            horizontalArrangement = Arrangement.spacedBy(16.dp)
//        ) {
//            PaymentButton(
//                modifier = Modifier.weight(1f),
//                title = "결제 수단",
//                subtitle = "추가 수단 등록"
//            )
//            PaymentButton(
//                modifier = Modifier.weight(1f),
//                title = "결제 내역",
//                subtitle = "결제 내역 보기"
//            )
//        }
        PaymentButton(
            modifier = Modifier.weight(1f),
            title = "결제 수단",
            onClick = { },
        )
        Spacer(modifier = Modifier.height(8.dp))
        PaymentButton(
            modifier = Modifier.weight(1f),
            title = "결제 내역",
            onClick = { },
        )
        Spacer(modifier = Modifier.height(8.dp))
        PaymentButton(
            modifier = Modifier.weight(1f),
            title = "내 정보 관리",
            onClick = { },
        )
    }
}

@Composable
private fun VerticalDivider() {
    Box(
        modifier = Modifier
            .width(1.dp)
            .height(24.dp)
            .background(Color(0xFFE0E0E0))
    )
}

@Composable
private fun BicycleCount(
    title: String,
    count: String
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            style = SwapTypography.BodyMedium,
            color = SwapColor.gray600,
        )
        Text(
            text = count,
            style = SwapTypography.BodyLarge,
            modifier = Modifier.padding(top = 4.dp),
            color = SwapColor.gray900,
        )
    }
}

@Composable
private fun PaymentButton(
    modifier: Modifier = Modifier,
    title: String,
    onClick: () -> Unit,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp)
            .background(
                shape = RoundedCornerShape(20.dp),
                color = SwapColor.gray0
            )
            .padding(
                horizontal = 24.dp,
                vertical = 12.dp,
            )
            .clickable(
                onClick = onClick
            ),
        verticalAlignment = Alignment.CenterVertically,
    ) {
        SwapText(
            text = title,
            style = SwapTypography.BodyLarge,
            color = SwapColor.gray900,
        )
        Spacer(modifier = Modifier.weight(1f))
        Icon(
            painter = painterResource(id = R.drawable.ic_arrow_right),
            contentDescription = "더보기",
            tint = SwapColor.gray300,
        )
    }
}