package com.alura.mobflix.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home_screen")
    object Register : Screen("register_video")
}