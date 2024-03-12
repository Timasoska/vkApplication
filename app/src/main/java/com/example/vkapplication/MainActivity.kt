package com.example.vkapplication

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.graphics.translationMatrix
import com.example.vkapplication.ui.theme.RowModel
import com.example.vkapplication.ui.theme.Sites

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
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
            LazyColumn(Modifier.fillMaxSize()) {
                itemsIndexed(
                    liftOf(

                    )
                ){_, item ->
                    RowModel(item = item)
                }

                //RowModel(item = Sites(R.drawable.telegram, "telegram", "dfdf", "kfgmk"))
            }

            Box(modifier = Modifier
                .fillMaxHeight()
                .padding(10.dp),
                contentAlignment = Alignment.TopStart)
            {
                fun onClick() {

                }
                FloatingActionButton(
                    //Засунуть всё в скалфорд
                    onClick = { onClick() },
                    shape = CircleShape,
                    containerColor = Color.Blue,
                    contentColor = Color.White,
                    elevation = FloatingActionButtonDefaults.elevation(48.dp),

                    ) {
                    Icon(Icons.Filled.Add, "button")
                }
            }

        /*    fun onClick() {

            }
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
        }

    } // floating Action button сразу уедет куда надо
}

