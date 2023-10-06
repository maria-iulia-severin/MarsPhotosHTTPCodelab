@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.marsphotos.ui

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.compose.rememberNavController
import com.example.marsphotos.ui.navigation.BottomNavItem
import com.example.marsphotos.ui.navigation.BottomNavigationBar
import com.example.marsphotos.ui.navigation.NavigationMars
import com.example.marsphotos.ui.navigation.Routes

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
        },
        bottomBar = {
            BottomNavigationBar(
                items = listOf(
                    BottomNavItem(
                        name = Routes.MARS.title,
                        route = Routes.MARS.route,
                        icon = Icons.Default.ArrowBack
                    ),
                    BottomNavItem(
                        name = Routes.REALESTATE.title,
                        route = Routes.REALESTATE.route,
                        icon = Icons.Default.ArrowForward
                    )
                ),
                navController = navController,
                onItemClick = {
                    navController.navigate(it.route)
                })
        }) { paddingValues ->
        NavigationMars(navController = navController, paddingValues)
    }
}









