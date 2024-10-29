package com.uiel.swap.ui.splash

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.uiel.swap.R
import com.uiel.swap.design_system.SwapTypography.SplashTitle
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(onTimeout: () -> Unit) {
    LaunchedEffect(true) {
        delay(2000)
        onTimeout()
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Spacer(modifier = Modifier.weight(1f))

        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "SWAP",
                style = SplashTitle,
                modifier = Modifier
                    .padding(top = 16.dp, bottom = 48.dp)
            )

            Image(
                painter = painterResource(id = R.drawable.splash_swap_logo),
                contentDescription = "splash swap logo",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1f, fill = false)
            )
        }
    }
}

//    Box(
//        modifier = Modifier
//            .fillMaxSize()
//            .background(Color.White)  // 흰색 배경 추가
//    ) {
//        // "SWAP" 텍스트 - 더 위쪽으로 배치하고 검은색으로 변경
//        Text(
//            text = "SWAP",
//            style = TextStyle(
//                fontSize = 48.sp,
//                fontWeight = FontWeight.Black,  // 더 굵은 폰트 웨이트
//                color = Color.Black  // 검은색으로 변경
//            ),
//            modifier = Modifier
//                .align(Alignment.TopCenter)
//                .padding(top = 80.dp)  // 상단 여백 증가
//        )
//
//        // 하단 로고 이미지
//        Image(
//            painter = painterResource(id = R.drawable.splash_swap_logo),
//            contentDescription = "splash swap logo",
//            modifier = Modifier
//                .align(Alignment.BottomCenter)
//                .padding(bottom = 100.dp)  // 하단 여백 추가
//        )
//    }