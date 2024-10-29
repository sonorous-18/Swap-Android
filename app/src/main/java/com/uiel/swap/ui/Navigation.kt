package com.uiel.swap.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.uiel.swap.ui.benefit.BenefitScreen
import com.uiel.swap.ui.home.HomeScreen
import com.uiel.swap.ui.map.MapScreen
import com.uiel.swap.ui.mypage.MyPageScreen

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = BottomNavItem.Home.route
    ) {
        composable(BottomNavItem.Home.route) {
            HomeScreen()
        }
        composable(BottomNavItem.Map.route) {
            MapScreen()
        }
        composable(BottomNavItem.Benefit.route) {
            BenefitScreen()
        }
        composable(BottomNavItem.MyPage.route) {
            MyPageScreen()
        }
    }
}