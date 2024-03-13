package com.example.vkapplication.ui.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.vkapplication.SampleData

@Composable
fun Screen2(navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "SCREEN2")
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavHostController){
    Scaffold(
        content = {
            LazyColumn {
                item {
                    Row(
                        modifier = Modifier
                            .background(Color.LightGray)
                            .fillMaxWidth()
                    ) {
                        Text(
                            modifier = Modifier.padding(10.dp),
                            text = "Passwords",
                            style = TextStyle(
                                fontWeight = FontWeight.Bold,
                                fontStyle = FontStyle.Italic,
                                fontSize = 18.sp
                            )
                        )
                    }
                }
                items(SampleData.sites) { site ->
                    RowModel(item = site)
                }
            }
        },
        floatingActionButton = {
            Box(
                contentAlignment = Alignment.BottomEnd,
                modifier = Modifier.padding(3.dp)
            ) {
                FloatingActionButton(
                    onClick = {navController.navigate("Screen2")},
                    shape = CircleShape,
                    containerColor = Color.Blue,
                    contentColor = Color.White,
                    elevation = FloatingActionButtonDefaults.elevation(48.dp),
                    modifier = Modifier
                        .align(Alignment.BottomEnd)
                ) {
                    Icon(Icons.Filled.Add, "button")
                }
            }
        }
    )
}