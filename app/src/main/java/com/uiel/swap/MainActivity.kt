package com.uiel.swap

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import com.uiel.swap.ui.main.MainScreen
import com.uiel.swap.ui.theme.SwapTheme
import android.os.Handler
import android.widget.Toast
import com.uiel.swap.ui.SwapApp

class MainActivity : ComponentActivity() {
//    private var doubleBackToExitPressedOnce = false
//    private val handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SwapTheme {
                SwapApp()
            }
        }
    }

//    override fun onBackPressed() {
//        if (doubleBackToExitPressedOnce) {
//            super.onBackPressed()
//            return
//        }
//
//        this.doubleBackToExitPressedOnce = true
//        Toast.makeText(this, "한 번 더 뒤로가기하면 종료됩니다.", Toast.LENGTH_SHORT).show()
//
//        handler.postDelayed({ doubleBackToExitPressedOnce = false }, 2000)
//    }
}
