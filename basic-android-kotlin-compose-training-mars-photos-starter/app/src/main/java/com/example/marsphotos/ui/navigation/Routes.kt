package com.example.marsphotos.ui.navigation

//enum
sealed class Routes(val route: String, val title: String) {
    //object MARS : Routes("mars", "Mars")
    object REALESTATE : Routes("realestate", "Real Estate")
    object INFOSCREEN : Routes("infoscreen", "Info Screen")
//    MARS("mars", "Mars"),
//    REALESTATE("realestate", "Real Estate"),
//    INFOSCREEN("infoscreen", "Info Screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}