package com.uiel.swap.feature.splash

import android.content.Intent
import android.os.Bundle
import com.uiel.swap.ui.splash.SplashScreen
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.uiel.swap.MainActivity

class SplashActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SplashScreen {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }
    }
}