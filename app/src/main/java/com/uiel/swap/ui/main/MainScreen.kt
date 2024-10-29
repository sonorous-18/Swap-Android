package com.uiel.swap.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.uiel.swap.ui.Navigation
import com.uiel.swap.ui.SwapBottomNavigation
import com.uiel.swap.viewmodel.main.MainViewModel
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MainScreen(
    viewModel: MainViewModel = viewModel()
) {
    val navController = rememberNavController()
    val selectedItem by viewModel.selectedItem.collectAsState()

    Scaffold(
        bottomBar = {
            SwapBottomNavigation(
                navController = navController,
                selectedItem = selectedItem,
                onItemSelected = { viewModel.onItemSelected(it) }
            )
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            Navigation(navController)
        }
    }
}