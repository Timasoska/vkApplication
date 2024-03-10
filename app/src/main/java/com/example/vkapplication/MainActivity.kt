package com.example.vkapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.vkapplication.ui.theme.ColumnModel
import com.example.vkapplication.ui.theme.Sites

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Row(modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
                .background(color = Color.White),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(text = "Сайт",
                    style = TextStyle(fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        fontSize = 18.sp))
                Text(text = "Логин",
                    style = TextStyle(fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        fontSize = 18.sp))
                Text(text = "Пароль",
                    style = TextStyle(fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Italic,
                        fontSize = 18.sp))
                LazyColumn(modifier = Modifier.fillMaxWidth()){//отсюда съезжает
                    itemsIndexed(
                        listOf(
                            Sites(R.drawable.telegram,"telegram","Login","passwd")
                        )
                    ){
                        _,item ->
                        ColumnModel(item = item)
                    }
                }
            }
        }
    }
}


