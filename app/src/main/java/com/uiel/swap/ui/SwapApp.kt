package com.uiel.swap.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.uiel.swap.ui.main.MainScreen
import com.uiel.swap.ui.management.ManagementScreen
import com.uiel.swap.ui.register.RegisterScreen
import com.uiel.swap.ui.subscribe.SubscribeDetailScreen
import com.uiel.swap.ui.subscribe.SubscribeManagementScreen

@Composable
fun SwapApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "app"
    ) {
        navigation(
            route = "app",
            startDestination = "main"
        ) {
            composable("main") {
                MainScreen(navController = navController)
            }
            composable("subscribeDetailScreen/{productId}") { backStackEntry ->
                val productId = backStackEntry.arguments?.getString("productId")?.toLong() ?: 0L
                SubscribeDetailScreen(
                    subscribeId = productId,
                    navController = navController,
                )
            }
            composable("management") {
                ManagementScreen(navController = navController)
            }
            composable("register") {
                RegisterScreen(navController)
            }
            composable("subscribeManagement") { 
                SubscribeManagementScreen(navController = navController)
            }
        }
    }
}