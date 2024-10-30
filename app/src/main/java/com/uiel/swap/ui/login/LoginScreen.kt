package com.uiel.swap.ui.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.uiel.swap.R
import com.uiel.swap.design_system.SwapTypography.SplashTitle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withStyle
import com.uiel.swap.design_system.SwapTypography.HeadlineSmall

@Composable
fun LoginScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.weight(1f))

        Text(
            text = "SWAP",
            style = SplashTitle,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.ic_line),
            contentDescription = "LINE logo",
            modifier = Modifier
                .size(74.dp)
                .padding(bottom = 16.dp)
        )

        Text(
            text = buildAnnotatedString {
                withStyle(style = SpanStyle(color = Color(0xFF00B900), fontSize = 24.sp)) {
                    append("라인으로")
                }
                append("\n간편하게 시작해보세요")
            },
            style = HeadlineSmall.copy(
                textAlign = TextAlign.Center,
            ),
            modifier = Modifier.padding(bottom = 16.dp)
        )

        Text(
            text = "조금 더 둘러볼래요",
            style = TextStyle(
                fontSize = 14.sp,
                color = Color.Gray
            ),
            modifier = Modifier.padding(bottom = 48.dp)
        )

        Image(
            painter = painterResource(id = R.drawable.splash_swap_character),
            contentDescription = "Swap Character",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .fillMaxWidth()
        )
    }
}
