package com.example.vkapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.room.Room
import com.example.vkapplication.ui.theme.MainScreen
import com.example.vkapplication.ui.theme.Screen2
import com.example.vkapplication.ui.theme.SiteDataBase

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            var database = Room.databaseBuilder(
                applicationContext,
                SiteDataBase::class.java,
                "site_database"
            ).build()
        } catch (e: Exception) {
            Log.e("MainActivity", "Error initializing database", e)
        }

        // Создание экземпляра базы данных
        var database = Room.databaseBuilder(
            applicationContext,
            SiteDataBase::class.java,
            "site_database"
        ).build()

        setContent {
            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "MainScreen"
            ){
                composable("MainScreen") {
                    // Здесь ваш контент для главного экрана
                    MainScreen(navController = navController, siteDao = database.dao)
                }

                composable("Screen2"){
                    Screen2(navController = navController, siteDao = database.dao)
                }

            }
        }
    }
}


