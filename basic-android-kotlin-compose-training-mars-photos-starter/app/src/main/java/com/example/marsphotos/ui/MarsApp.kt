@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.marsphotos.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.compose.rememberNavController
import com.example.marsphotos.ui.navigation.NavigationMars

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MarsApp() {
    val navController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Mars App",
                        color = Color.Gray,
                        fontWeight = FontWeight.SemiBold
                    )
                }
            )
        }
    )
    { paddingValues ->
        NavigationMars(navController = navController, paddingValues)
    }
}








