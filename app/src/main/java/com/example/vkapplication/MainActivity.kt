package com.example.vkapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
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
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp)
                    .background(color = Color.White),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Сайт",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Italic,
                            fontSize = 18.sp
                        )
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "Логин",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Italic,
                            fontSize = 18.sp
                        )
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = "Пароль",
                        style = TextStyle(
                            fontWeight = FontWeight.Bold,
                            fontStyle = FontStyle.Italic,
                            fontSize = 18.sp
                        )
                    )
                }
                LazyColumn(modifier = Modifier.fillMaxWidth()) {
                    itemsIndexed(
                        listOf(
                            Sites(R.drawable.telegram, "telegram", "Login", "passwd")
                        )
                    ) { _, item ->
                        ColumnModel(item = item)
                    }
                }
            }
        }

    }
}
/*@Composable
fun ColumnModel(item: Sites) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = item.icon),
            contentDescription = null,
            modifier = Modifier.size(64.dp)
        )
        Spacer(modifier = Modifier.width(16.dp))
        Column {
            Text(
                text = item.title,
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    fontSize = 18.sp
                )
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = "Login: ${item.login}",
                style = TextStyle(fontSize = 14.sp)
            )
            Text(
                text = "Password: ${item.password}",
                style = TextStyle(fontSize = 14.sp)
            )
        }
    }
}*/


