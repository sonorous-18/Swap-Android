package com.uiel.swap.design_system

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import com.uiel.swap.R

private val PretendardKrFamily = FontFamily(
    listOf(
        Font(
            resId = R.font.pretendard_bold_kr,
            weight = FontWeight.Bold,
        ),
        Font(
            resId = R.font.pretendard_medium_kr,
            weight = FontWeight.Medium,
        ),
        Font(
            resId = R.font.pretendard_semi_bold_kr,
            weight = FontWeight.SemiBold,
        ),
    ),
)

private val PretendardJpFamily = FontFamily(
    listOf(
        Font(
            resId = R.font.pretendard_bold_jp,
            weight = FontWeight.Bold,
        ),
        Font(
            resId = R.font.pretendard_medium_jp,
            weight = FontWeight.Medium,
        ),
        Font(
            resId = R.font.pretendard_semi_bold_jp,
            weight = FontWeight.SemiBold,
        ),
    ),
)

private val RixInooAriDuriFamily = FontFamily(
    Font(
        resId = R.font.rixinooariduri_pro_regular,
        weight = FontWeight.Normal
    )
)

private val platFormTextStyle = PlatformTextStyle(
    includeFontPadding = false,
)

object SwapTypography {
    val DisplayLarge
        @Composable get() = TextStyle(
            fontFamily = PretendardKrFamily,
            fontSize = 57.sp,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 64.sp,
            platformStyle = platFormTextStyle,
            letterSpacing = (-0.015).em
        )

    val DisplayMedium
        @Composable get() = TextStyle(
            fontFamily = PretendardKrFamily,
            fontSize = 45.sp,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 52.sp,
            platformStyle = platFormTextStyle,
            letterSpacing = (-0.015).em
        )

    val DisplaySmall
        @Composable get() = TextStyle(
            fontFamily = PretendardKrFamily,
            fontSize = 36.sp,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 44.sp,
            platformStyle = platFormTextStyle,
            letterSpacing = (-0.015).em
        )

    val HeadlineLarge
        @Composable get() = TextStyle(
            fontFamily = PretendardKrFamily,
            fontSize = 32.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 40.sp,
            platformStyle = platFormTextStyle,
            letterSpacing = (-0.015).em
        )

    val HeadlineMedium
        @Composable get() = TextStyle(
            fontFamily = PretendardKrFamily,
            fontSize = 28.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 36.sp,
            platformStyle = platFormTextStyle,
            letterSpacing = (-0.015).em
        )

    val HeadlineSmall
        @Composable get() = TextStyle(
            fontFamily = PretendardKrFamily,
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 32.sp,
            platformStyle = platFormTextStyle,
            letterSpacing = (-0.015).em
        )

    val TitleLarge
        @Composable get() = TextStyle(
            fontFamily = PretendardKrFamily,
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 28.sp,
            platformStyle = platFormTextStyle,
            letterSpacing = (-0.015).em
        )

    val TitleMedium
        @Composable get() = TextStyle(
            fontFamily = PretendardKrFamily,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 24.sp,
            platformStyle = platFormTextStyle,
            letterSpacing = (-0.015).em
        )

    val TitleSmall
        @Composable get() = TextStyle(
            fontFamily = PretendardKrFamily,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 20.sp,
            platformStyle = platFormTextStyle,
            letterSpacing = (-0.015).em
        )

    val BodyLarge
        @Composable get() = TextStyle(
            fontFamily = PretendardKrFamily,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 24.sp,
            platformStyle = platFormTextStyle,
            letterSpacing = (-0.015).em
        )

    val BodyMedium
        @Composable get() = TextStyle(
            fontFamily = PretendardKrFamily,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 20.sp,
            platformStyle = platFormTextStyle,
            letterSpacing = (-0.015).em
        )

    val BodySmall
        @Composable get() = TextStyle(
            fontFamily = PretendardKrFamily,
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 16.sp,
            platformStyle = platFormTextStyle,
            letterSpacing = (-0.015).em
        )

    val LabelLarge
        @Composable get() = TextStyle(
            fontFamily = PretendardKrFamily,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 20.sp,
            platformStyle = platFormTextStyle,
            letterSpacing = (-0.015).em
        )

    val LabelMedium
        @Composable get() = TextStyle(
            fontFamily = PretendardKrFamily,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 16.sp,
            platformStyle = platFormTextStyle,
            letterSpacing = (-0.015).em
        )

    val LabelSmall
        @Composable get() = TextStyle(
            fontFamily = PretendardKrFamily,
            fontSize = 11.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 16.sp,
            platformStyle = platFormTextStyle,
            letterSpacing = (-0.015).em
        )

    val SplashTitle
        @Composable get() = TextStyle(
            fontFamily = RixInooAriDuriFamily,
            fontSize = 48.sp,
            color = Color(0xFF8256EA),
            fontWeight = FontWeight.Normal,
            lineHeight = 72.sp,
            platformStyle = platFormTextStyle,
        )
}

object SwapTypographyJP {
    val DisplayLarge
        @Composable get() = TextStyle(
            fontFamily = PretendardJpFamily,
            fontSize = 57.sp,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 64.sp,
            platformStyle = platFormTextStyle,
            letterSpacing = (-0.015).em
        )

    val DisplayMedium
        @Composable get() = TextStyle(
            fontFamily = PretendardJpFamily,
            fontSize = 45.sp,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 52.sp,
            platformStyle = platFormTextStyle,
            letterSpacing = (-0.015).em
        )

    val DisplaySmall
        @Composable get() = TextStyle(
            fontFamily = PretendardJpFamily,
            fontSize = 36.sp,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 44.sp,
            platformStyle = platFormTextStyle,
            letterSpacing = (-0.015).em
        )

    val HeadlineLarge
        @Composable get() = TextStyle(
            fontFamily = PretendardJpFamily,
            fontSize = 32.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 40.sp,
            platformStyle = platFormTextStyle,
            letterSpacing = (-0.015).em
        )

    val HeadlineMedium
        @Composable get() = TextStyle(
            fontFamily = PretendardJpFamily,
            fontSize = 28.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 36.sp,
            platformStyle = platFormTextStyle,
            letterSpacing = (-0.015).em
        )

    val HeadlineSmall
        @Composable get() = TextStyle(
            fontFamily = PretendardJpFamily,
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 32.sp,
            platformStyle = platFormTextStyle,
            letterSpacing = (-0.015).em
        )

    val TitleLarge
        @Composable get() = TextStyle(
            fontFamily = PretendardJpFamily,
            fontSize = 22.sp,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 28.sp,
            platformStyle = platFormTextStyle,
            letterSpacing = (-0.015).em
        )

    val TitleMedium
        @Composable get() = TextStyle(
            fontFamily = PretendardJpFamily,
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 24.sp,
            platformStyle = platFormTextStyle,
            letterSpacing = (-0.015).em
        )

    val TitleSmall
        @Composable get() = TextStyle(
            fontFamily = PretendardJpFamily,
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            lineHeight = 20.sp,
            platformStyle = platFormTextStyle,
            letterSpacing = (-0.015).em
        )

    val BodyLarge
        @Composable get() = TextStyle(
            fontFamily = PretendardJpFamily,
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 24.sp,
            platformStyle = platFormTextStyle,
            letterSpacing = (-0.015).em
        )

    val BodyMedium
        @Composable get() = TextStyle(
            fontFamily = PretendardJpFamily,
            fontSize = 14.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 20.sp,
            platformStyle = platFormTextStyle,
            letterSpacing = (-0.015).em
        )

    val BodySmall
        @Composable get() = TextStyle(
            fontFamily = PretendardJpFamily,
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            lineHeight = 16.sp,
            platformStyle = platFormTextStyle,
            letterSpacing = (-0.015).em
        )

    val LabelLarge
        @Composable get() = TextStyle(
            fontFamily = PretendardJpFamily,
            fontSize = 14.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 20.sp,
            platformStyle = platFormTextStyle,
            letterSpacing = (-0.015).em
        )

    val LabelMedium
        @Composable get() = TextStyle(
            fontFamily = PretendardJpFamily,
            fontSize = 12.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 16.sp,
            platformStyle = platFormTextStyle,
            letterSpacing = (-0.015).em
        )

    val LabelSmall
        @Composable get() = TextStyle(
            fontFamily = PretendardJpFamily,
            fontSize = 11.sp,
            fontWeight = FontWeight.Medium,
            lineHeight = 16.sp,
            platformStyle = platFormTextStyle,
            letterSpacing = (-0.015).em
        )
}