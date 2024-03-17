package com.example.vkapplication.presentation

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode.Companion.Screen
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.fragment.app.FragmentActivity
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.vkapplication.biometric.BiometricAuth
import com.example.vkapplication.biometric.BiometricAuthStatus
import com.example.vkapplication.presentation.detail.DetailScreen
import com.example.vkapplication.presentation.detail.DetailViewModel
import com.example.vkapplication.presentation.main.MainScreen
import com.example.vkapplication.presentation.main.MainViewModel
import com.example.vkapplication.presentation.main.Screen

class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val biometricAuthenticator = BiometricAuth(this)
        val mainViewModel by viewModels<MainViewModel> { MainViewModel.Factory }
        val detailViewModel by viewModels<DetailViewModel> { DetailViewModel.Factory }

        setContent {
            val navController = rememberNavController()


            NavHost(
                navController = navController,
                startDestination = "Screen" ,
                enterTransition = { EnterTransition.None },
                exitTransition = { ExitTransition.None },
            ) {

                composable("Screen") {
                    Screen(navController = navController, biometricAuthenticator)
                }

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


