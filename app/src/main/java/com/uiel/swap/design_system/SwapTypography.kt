package com.uiel.swap.design_system

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.uiel.swap.R

private val PretendardFamily = FontFamily(
    listOf(
        Font(
            resId = R.font.pretendard_bold,
            weight = FontWeight.Bold,
        ),
        Font(
            resId = R.font.pretendard_medium,
            weight = FontWeight.Medium,
        ),
        Font(
            resId = R.font.pretendard_semi_bold,
            weight = FontWeight.SemiBold,
        ),
    ),
)

private val platFormTextStyle = PlatformTextStyle(
    includeFontPadding = false,
)

object SwapTypography {
    val DisplayLarge
        @Composable get() = TextStyle(
            fontFamily = PretendardFamily,
            fontSize = 57.sp,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 64.sp,
            platformStyle = platFormTextStyle,
            letterSpacing = (-1.5).sp
        )

    val DisplayMedium
        @Composable get() = TextStyle(
            fontFamily = PretendardFamily,
            fontSize = 45.sp,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 52.sp,
            platformStyle = platFormTextStyle,
            letterSpacing = (-1.5).sp
        )

    val DisplaySmall
        @Composable get() = TextStyle(
            fontFamily = PretendardFamily,
            fontSize = 36.sp,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 44.sp,
            platformStyle = platFormTextStyle,
            letterSpacing = (-1.5).sp
        )

    val HeadlineLarge
        @Composable get() = TextStyle(
            fontFamily = PretendardFamily,
            fontSize = 32.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 40.sp,
            platformStyle = platFormTextStyle,
            letterSpacing = (-1.5).sp
        )

    val HeadlineMedium
        @Composable get() = TextStyle(
            fontFamily = PretendardFamily,
            fontSize = 28.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 36.sp,
            platformStyle = platFormTextStyle,
            letterSpacing = (-1.5).sp
        )

    val HeadlineSmall
        @Composable get() = TextStyle(
            fontFamily = PretendardFamily,
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 32.sp,
            platformStyle = platFormTextStyle,
            letterSpacing = (-1.5).sp
        )

    val TitleLarge
        @Composable get() = TextStyle(
            fontFamily = PretendardFamily,
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 28.sp,
            platformStyle = platFormTextStyle,
            letterSpacing = (-1.5).sp
        )

    val TitleMedium
        @Composable get() = TextStyle(
            fontFamily = PretendardFamily,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 24.sp,
            platformStyle = platFormTextStyle,
            letterSpacing = (-1.5).sp
        )

    val TitleSmall
        @Composable get() = TextStyle(
            fontFamily = PretendardFamily,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 20.sp,
            platformStyle = platFormTextStyle,
            letterSpacing = (-1.5).sp
        )

    val BodyLarge
        @Composable get() = TextStyle(
            fontFamily = PretendardFamily,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 24.sp,
            platformStyle = platFormTextStyle,
            letterSpacing = (-1.5).sp
        )

    val BodyMedium
        @Composable get() = TextStyle(
            fontFamily = PretendardFamily,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 20.sp,
            platformStyle = platFormTextStyle,
            letterSpacing = (-1.5).sp
        )

    val BodySmall
        @Composable get() = TextStyle(
            fontFamily = PretendardFamily,
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 16.sp,
            platformStyle = platFormTextStyle,
            letterSpacing = (-1.5).sp
        )

    val LabelLarge
        @Composable get() = TextStyle(
            fontFamily = PretendardFamily,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 20.sp,
            platformStyle = platFormTextStyle,
            letterSpacing = (-1.5).sp
        )

    val LabelMedium
        @Composable get() = TextStyle(
            fontFamily = PretendardFamily,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 16.sp,
            platformStyle = platFormTextStyle,
            letterSpacing = (-1.5).sp
        )

    val LabelSmall
        @Composable get() = TextStyle(
            fontFamily = PretendardFamily,
            fontSize = 11.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 16.sp,
            platformStyle = platFormTextStyle,
            letterSpacing = (-1.5).sp
        )
}
