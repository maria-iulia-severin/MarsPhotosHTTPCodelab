package com.example.marsphotos.ui.screens.realEstateScreen.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import coil.compose.AsyncImage
import com.example.marsphotos.network.RealEstate
import com.example.marsphotos.ui.navigation.Routes
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RealEstateCard(
    index: Int,
    realEstate: RealEstate,
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    Card(
        onClick = {
            val encImageUrl =
                URLEncoder.encode(realEstate.imageUrl, StandardCharsets.UTF_8.toString())
            val route = Routes.INFOSCREEN.route + "/$encImageUrl/${index}"
            navController.navigate(route)
        },
        shape = RoundedCornerShape(8.dp),
        modifier = modifier.padding(10.dp, 5.dp, 10.dp, 10.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp,
        )
    ) {
        Column(modifier = Modifier.background(color = Color.White)) {
            AsyncImage(
                model = realEstate.imageUrl,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .height(150.dp)
                    .fillMaxWidth()
            )
            Text(
                text = index.toString(),
                color = Color.Blue,
                modifier = Modifier.padding(horizontal = 150.dp),
            )
        }
    }
}