package com.example.marsphotos.ui.navigation

sealed class Routes(val route: String, val title: String) {
    object MARS : Routes("mars", "Mars")
    object REALESTATE : Routes("realestate", "Real Estate")
    object INFOSCREEN : Routes("infoscreen", "Info Screen")
}