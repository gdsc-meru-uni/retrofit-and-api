package com.hcr.retro_and_api.presentation.screens

sealed class Screens(val route: String){
    object HomeScreen:Screens(route = "HomeScreen")
    object DetailsScreen:Screens(route = "DetailsScreen")
}
