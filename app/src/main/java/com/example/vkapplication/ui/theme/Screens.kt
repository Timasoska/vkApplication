package com.example.vkapplication.ui.theme

import android.annotation.SuppressLint
import android.util.Log
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
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Title
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import androidx.core.os.bundleOf
import kotlinx.coroutines.flow.firstOrNull


//var SampleData = mutableListOf<Sites>()

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Screen2(navController: NavHostController, siteDao: Dao) {
    // State для хранения данных сайта
    val siteState = remember { mutableStateOf<Sites?>(null) }


    Column(
        horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        var login by rememberSaveable { mutableStateOf("")}
        //var title by rememberSaveable { mutableStateOf("")}
        var title by rememberSaveable { mutableStateOf(siteState.value?.title ?: "") }
        var password by rememberSaveable { mutableStateOf("")}
        var passwordVisible by rememberSaveable { mutableStateOf(false)}
        var url by rememberSaveable { mutableStateOf("")}

        OutlinedTextField(
            value = title,
            onValueChange = {title = it},
            label = {Text("Название")},
            modifier = Modifier.padding(20.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Title,
                    contentDescription = null
                )
            }
        )
        Log.d("Screen2", "Title value: $title")
        OutlinedTextField(
            value = login,
            onValueChange = {login = it},
            label = {Text("Логин")},
            modifier = Modifier.padding(20.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Email,
                    contentDescription = null
                )
            }
        )
        OutlinedTextField(
            value = password,
            onValueChange = {password = it},
            label = {Text("Пароль")},
            modifier = Modifier.padding(20.dp),
            visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                val image = if (passwordVisible)
                    Icons.Filled.Visibility
                else Icons.Filled.VisibilityOff

                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(imageVector = image, "button")
                }
            },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Lock,
                    contentDescription = null,
                    modifier = Modifier
                )
            },
        )
        OutlinedTextField(
            value = url,
            onValueChange = {url = it},
            label = {Text("Веб-сайт")},
            modifier = Modifier.padding(20.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Uri),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = null
                )
            }
        )

        Button(onClick = {
            val newSite = Sites(
                imageUrl = url,
                title = title,
                login = login,
                password = password
            )
            try {
                // Insert the new site into the database
                CoroutineScope(Dispatchers.IO).launch {
                    siteDao.insertSite(newSite)
                }
            } catch (e: Exception) {
                // Log the exception
                Log.e("InsertSite", "Error inserting site", e)
            }


        }) {
            Text("Добавить")
        }
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavHostController, siteDao: Dao){
    // Загрузка данных из базы данных
    val sites by siteDao.getSites().collectAsState(initial = emptyList())

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
                items(sites) { site ->
                    RowModel(item = site, onDeleteClicked ={
                        try {
                            CoroutineScope(Dispatchers.IO).launch {
                                siteDao.deleteSite(site)
                            }
                        } catch (e: Exception) {
                            // Log the exception
                            Log.e("DeleteSite", "Error deleting site", e)
                        }
                    }, onClick = {
                        //Берем данные с БД
                        navController.navigate("Screen2")
                    })
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




