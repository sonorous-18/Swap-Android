package com.uiel.swap.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.uiel.swap.ui.BottomNavItem
import com.uiel.swap.ui.RootScreen
import com.uiel.swap.ui.SwapBottomNavigation
import com.uiel.swap.ui.benefit.BenefitScreen
import com.uiel.swap.ui.home.HomeScreen
import com.uiel.swap.ui.map.MapScreen
import com.uiel.swap.ui.mypage.MyPageScreen
import com.uiel.swap.ui.subscribe.SubscribeDetailScreen
import com.uiel.swap.viewmodel.main.MainViewModel

@Composable
fun MainScreen(
    viewModel: MainViewModel = viewModel(),
    navController: NavController,
) {
    val navHostController = rememberNavController()
    val selectedItem by viewModel.selectedItem.collectAsState()

    Scaffold(
        bottomBar = {
            SwapBottomNavigation(
                navController = navHostController,
                selectedItem = selectedItem,
                onItemSelected = { viewModel.onItemSelected(it) }
            )
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            NavHost(
                navController = navHostController,
                startDestination = BottomNavItem.Home.route
            ) {
                composable(BottomNavItem.Home.route) {
                    HomeScreen(navController = navController)
                }
                composable(BottomNavItem.Map.route) {
                    MapScreen()
                }
                composable(BottomNavItem.Benefit.route) {
                    BenefitScreen()
                }
                composable(BottomNavItem.MyPage.route) {
                    MyPageScreen(navController)
                }
            }
        }
    }
}