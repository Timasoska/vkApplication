package com.example.vkapplication.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun RowModel(item: Sites){
    Row(modifier = Modifier.fillMaxWidth()) {
        Image(
            painter = painterResource(id = item.icon),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .padding(3.dp)
                .size(64.dp)
                .clip(CircleShape)
        )
        Column {
            Text(
                text = item.title,
                modifier = Modifier
                    .padding(5.dp)
            )
            Text( //Сделать серый цвет
                text = item.login,
                modifier = Modifier
                    .padding(5.dp)
                )
        }
    }

}