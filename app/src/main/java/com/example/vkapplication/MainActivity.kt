package com.example.vkapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.vkapplication.ui.theme.DataStore
import com.example.vkapplication.ui.theme.MainScreen
import com.example.vkapplication.ui.theme.RowModel
import com.example.vkapplication.ui.theme.SampleData
import com.example.vkapplication.ui.theme.Screen2
import com.example.vkapplication.ui.theme.Sites

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val dataStore = DataStore(this)

            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "MainScreen"
            ){
                composable("MainScreen") {
                    // Здесь ваш контент для главного экрана
                    MainScreen(navController = navController, dataStore = dataStore)
                }

                composable("Screen2"){
                    Screen2(navController = navController, dataStore = dataStore)
                }

            }
        }
    }
}


