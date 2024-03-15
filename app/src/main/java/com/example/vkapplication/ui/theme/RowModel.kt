package com.example.vkapplication.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter
import com.example.vkapplication.R


@Composable
fun RowModel(item:  Sites){


    Column(modifier = Modifier
        .fillMaxWidth()
        .clickable(onClick = {})
        .shadow(1.dp),
        Arrangement.Center
    ){
        FaviconImage(url = item.imageUrl)
        Row (
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        ){
            Text(
                text = item.title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .padding(5.dp,3.dp)
            )
            Text( //Сделать серый цвет
                text = item.login,
                color = Color.DarkGray,
                fontSize = 15.sp,
                modifier = Modifier
                    .padding(5.dp, 3.dp)
                )
        }
        // Помещаем иконку мусорки за пределами Row
        IconButton(
            onClick = {
                // Удаляем элемент из базы данных
            },
            modifier = Modifier.align(Alignment.End) // Выравниваем иконку по правому краю
        ) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Delete"
            )
        }
    }
}
@Composable
fun FaviconImage(url: String) {
    // Получаем URL фавикона
    val faviconUrl = "https://www.google.com/s2/favicons?domain=$url"

    // Используем Coil для загрузки изображения
    val painter: Painter = rememberImagePainter(
        data = faviconUrl,
        builder = {
            size(64)
            placeholder(R.drawable.telegram) // Заглушка, которая отобразится во время загрузки
        }
    )
    // Отображаем изображение с использованием фавикона
    Image(
        painter = painter,
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(64.dp)
            .clip(CircleShape)
            //.padding(3.dp)
    )
}
