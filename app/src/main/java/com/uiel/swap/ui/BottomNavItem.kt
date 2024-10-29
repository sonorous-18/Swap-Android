package com.uiel.swap.ui

import com.uiel.swap.R

sealed class BottomNavItem(
    val route: String,
    val title: String,
    val icon: Int
) {
    data object Home : BottomNavItem("home", "홈", R.drawable.ic_home)
    data object Map : BottomNavItem("map", "지도", R.drawable.ic_map)
    data object Benefit : BottomNavItem("benefit", "혜택", R.drawable.ic_benefit)
    data object MyPage : BottomNavItem("mypage", "마이 페이지", R.drawable.ic_mypage)
}