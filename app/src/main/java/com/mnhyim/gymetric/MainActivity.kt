package com.mnhyim.gymetric

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.mnhyim.gymetric.ui.feature.HomeScreen
import com.mnhyim.gymetric.ui.theme.GymetricTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            GymetricTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) { _ ->
                    HomeScreen()
                }
            }
        }
    }
}
