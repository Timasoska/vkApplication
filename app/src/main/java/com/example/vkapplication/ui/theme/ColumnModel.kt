package com.example.vkapplication.ui.theme

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import org.w3c.dom.Text

@Composable
fun ColumnModel(item: Sites){
    Column(horizontalAlignment = Alignment.Start,
        modifier = Modifier
            .background(Color.White)
            .padding(3.dp)
    ){
        Image(painter = painterResource(id = item.icon),
            contentDescription = null,
            contentScale = ContentScale.Crop, //Обрезаный
            modifier = Modifier
                .padding(3.dp)
                .size(64.dp)
                .clip(CircleShape)
        )
    }
}