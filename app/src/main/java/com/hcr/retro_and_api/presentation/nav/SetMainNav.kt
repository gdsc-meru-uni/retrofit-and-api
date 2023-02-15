package com.hcr.retro_and_api.presentation.nav

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.hcr.retro_and_api.presentation.screens.HomeScreen
import com.hcr.retro_and_api.presentation.screens.Screens

@Composable
fun SetMainNav() {
    val navHostController: NavHostController = rememberNavController()

    NavHost(navController = navHostController, startDestination = Screens.HomeScreen.route){
        composable(
            route = Screens.HomeScreen.route
        ){
            HomeScreen()
        }
    }
}