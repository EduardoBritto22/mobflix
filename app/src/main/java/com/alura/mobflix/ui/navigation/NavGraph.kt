package com.alura.mobflix.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.alura.mobflix.sampledata.sampleVideos
import com.alura.mobflix.ui.screen.HomeScreen
import com.alura.mobflix.ui.screen.RegisterScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {
            HomeScreen(navController = navController, highlightVideo = sampleVideos.first(), videos = sampleVideos)
        }
        composable(
            route = Screen.Register.route,
        ) {
            RegisterScreen(navController)
        }
    }
}