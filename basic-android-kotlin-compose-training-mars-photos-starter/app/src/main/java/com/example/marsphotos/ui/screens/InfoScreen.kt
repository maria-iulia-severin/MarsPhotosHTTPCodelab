package com.example.marsphotos.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun InfoScreen(imageUrl: String?, price: Int?) {
    Box(
        modifier = Modifier.padding(8.dp)
    ) {
        Column {
            Text(
                text = "$price",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 50.sp,
                color = Color.White
            )

            AsyncImage(
                model = imageUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
            )
        }
    }
}