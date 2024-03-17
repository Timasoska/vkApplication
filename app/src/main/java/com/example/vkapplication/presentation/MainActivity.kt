package com.example.vkapplication.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.vkapplication.presentation.detail.DetailScreen
import com.example.vkapplication.presentation.detail.DetailViewModel
import com.example.vkapplication.presentation.main.MainScreen
import com.example.vkapplication.presentation.main.MainViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val mainViewModel by viewModels<MainViewModel> { MainViewModel.Factory }
        val detailViewModel by viewModels<DetailViewModel> { DetailViewModel.Factory }

        setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "main"
            ) {
                composable("main") {
                    // Здесь ваш контент для главного экрана
                    MainScreen(navController = navController, mainViewModel)
                }

                composable(
                    "detail/{siteId}",
                    arguments = listOf(navArgument("siteId") { type = NavType.IntType })
                ) { backStackEntry ->
                    DetailScreen(
                        navController = navController,
                        detailViewModel,
                        backStackEntry.arguments!!.getInt("siteId"),
                    )
                }

            }
        }
    }
}


