package com.example.vkapplication

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Space
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
import androidx.core.graphics.translationMatrix
import com.example.vkapplication.ui.theme.RowModel
import com.example.vkapplication.ui.theme.Sites

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
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
                            RowModel(item = site)
                            RowModel(item = site)
                            RowModel(item = site)
                            RowModel(item = site)
                            RowModel(item = site)
                            RowModel(item = site)
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
                            onClick = { /* Handle click here */ },
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
    }
}


object SampleData {
    val sites = listOf(
        Sites(R.drawable.telegram, "telegram", "dfdf", "kfgmk"),
        Sites(R.drawable.telegram, "telegram", "dfdf", "kfgmk"),
        // Add more sample data here if needed
    )
}

/*class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Box(modifier = Modifier.fillMaxSize()) {
                Column(Modifier.fillMaxSize()) {
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
                    RowModel(item = Sites(R.drawable.telegram, "telegram", "dfdf", "kfgmk"))
                    RowModel(item = Sites(R.drawable.telegram, "telegram", "dfdf", "kfgmk"))
                }
                FloatingActionButton(
                    onClick = { *//* Handle click here *//* },
                    shape = CircleShape,
                    containerColor = Color.Blue,
                    contentColor = Color.White,
                    elevation = FloatingActionButtonDefaults.elevation(48.dp),
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.BottomEnd) // Align to bottom end of the screen
                ) {
                    Icon(Icons.Filled.Add, "button")
                }
            }
        }
    }
}*/

/*
FloatingActionButton(
//Засунуть всё в скалфорд
onClick = { onClick() },
shape = CircleShape,
containerColor = Color.Blue,
contentColor = Color.White,
elevation = FloatingActionButtonDefaults.elevation(48.dp),

) {
    Icon(Icons.Filled.Add, "button")
}*/
