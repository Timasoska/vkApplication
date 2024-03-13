package com.example.vkapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.vkapplication.ui.theme.MainScreen
import com.example.vkapplication.ui.theme.RowModel
import com.example.vkapplication.ui.theme.Screen2
import com.example.vkapplication.ui.theme.Sites

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()

            NavHost(
                navController = navController,
                startDestination = "MainScreen"
            ){
                composable("MainScreen") {
                    // Здесь ваш контент для главного экрана
                    MainScreen(navController = navController)
                }

                composable("Screen2"){
                    Screen2(navController = navController)
                }

            }
        }
    }
}


object SampleData {
    val sites = listOf(
        Sites("https://music.yandex.ru/home","Yandex", "dfdf", "kfgmk"),
        Sites("https://www.google.ru","Yandex", "dfdf", "kfgmk"),
        Sites("https://www.google.ru","Yandex", "dfdf", "kfgmk"),
        Sites("https://www.google.ru","Yandex", "dfdf", "kfgmk"),
        Sites("https://www.google.ru","Yandex", "dfdf", "kfgmk"),
        Sites("https://www.google.ru","Yandex", "dfdf", "kfgmk"),
        Sites("https://www.google.ru","Yandex", "dfdf", "kfgmk"),
        Sites("https://www.google.ru","Yandex", "dfdf", "kfgmk"),
        Sites("https://www.google.ru","Yandex", "dfdf", "kfgmk"),
        Sites("https://www.google.ru","Yandex", "dfdf", "kfgmk"),
        Sites("https://www.google.ru","Yandex", "dfdf", "kfgmk"),
        Sites("https://www.google.ru","Yandex", "dfdf", "kfgmk"),
        Sites("https://www.google.ru","Yandex", "dfdf", "kfgmk"),
        Sites("https://www.google.ru","Yandex", "dfdf", "kfgmk"),
        Sites("https://www.google.ru","Yandex", "dfdf", "kfgmk"),
        Sites("https://www.google.ru","Yandex", "dfdf", "kfgmk"),
        Sites("https://www.google.ru","Yandex", "dfdf", "kfgmk"),
        Sites("https://www.google.ru","Yandex", "dfdf", "kfgmk"),
        Sites("https://www.google.ru","Yandex", "dfdf", "kfgmk"),
        //Sites(R.drawable.telegram, "telegram", "dfdf", "kfgmk"),
    )
}
