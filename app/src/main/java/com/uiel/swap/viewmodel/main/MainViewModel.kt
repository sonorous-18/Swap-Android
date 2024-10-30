package com.uiel.swap.viewmodel.main

import androidx.lifecycle.ViewModel
import com.uiel.swap.ui.BottomNavItem
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class MainViewModel : ViewModel() {
    private val _selectedItem = MutableStateFlow<BottomNavItem>(BottomNavItem.Home)
    val selectedItem: StateFlow<BottomNavItem> = _selectedItem.asStateFlow()

    fun onItemSelected(item: BottomNavItem) {
        _selectedItem.value = item
    }
}