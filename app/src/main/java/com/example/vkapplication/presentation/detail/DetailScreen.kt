package com.example.vkapplication.presentation.detail

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Title
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.vkapplication.data.Site
import com.example.vkapplication.presentation.common.LoadingScreen

@Composable
fun DetailScreen(navController: NavHostController, viewModel: DetailViewModel, siteId: Int) {

    val state by viewModel.getState(siteId).collectAsState()
    when(state) {
        DetailScreenState.Loading -> LoadingScreen()
        is DetailScreenState.Success -> SuccessScreen((state as DetailScreenState.Success).site, navController, viewModel)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun SuccessScreen(
    site: Site,
    navController: NavHostController,
    viewModel: DetailViewModel
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {
        var login by rememberSaveable { mutableStateOf(site.login) }
        var title by rememberSaveable { mutableStateOf(site.title) }
        var password by rememberSaveable { mutableStateOf(site.password) }
        var passwordVisible by rememberSaveable { mutableStateOf(false) }
        var url by rememberSaveable { mutableStateOf(site.websiteUrl) }

        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Название") },
            modifier = Modifier.padding(20.dp),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
            leadingIcon = {
                Icon(
                    imageVector = Icons.Filled.Title,
                    contentDescription = null
                )
            }
        )
        Log.d("DetailScreen", "Title value: $title")
        OutlinedTextField(
            value = login,
            onValueChange = { login = it },
            label = { Text("Логин") },
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
            onValueChange = { password = it },
            label = { Text("Пароль") },
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
            onValueChange = { url = it },
            label = { Text("Веб-сайт") },
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
            viewModel.handleUserAction(
                DetailScreenUserAction.Update(
                Site(
                    id = site.id,
                    title = title,
                    login = login,
                    password = password,
                    websiteUrl = url,

                )
            ))
            navController.navigate("main")
        }) {
            Text("Сохранить")
        }
    }
}
