package com.alura.mobflix.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.alura.mobflix.ui.screen.EditRoute
import com.alura.mobflix.ui.screen.HomeRoute
import com.alura.mobflix.ui.screen.RegisterScreen

@Composable
fun NavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        composable(route = Screen.Home.route) {

            HomeRoute(
                navController = navController
            )
        }
        composable(
            route = Screen.Register.route,
        ) {
            RegisterScreen(navController)
        }
        composable(
            route = Screen.Edit.route+"/{videoId}",
            arguments = listOf(
                navArgument("videoId") { type = NavType.IntType }
            )
        ) {
            EditRoute(navController)
        }
    }
}