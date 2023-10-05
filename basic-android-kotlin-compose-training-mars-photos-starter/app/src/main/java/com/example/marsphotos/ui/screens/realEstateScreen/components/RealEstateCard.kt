package com.example.marsphotos.ui.screens.realEstateScreen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.marsphotos.network.RealEstate

@Composable
fun RealEstateCard(realEstate: RealEstate, modifier: Modifier = Modifier) {
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = modifier.padding(10.dp, 5.dp, 10.dp, 10.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 10.dp,
        )
    ) {
        AsyncImage(
            model = realEstate.imageUrl,
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(150.dp)
                .fillMaxWidth()
        )
        Text(
            text = realEstate.price.toString(),
            modifier = Modifier
                .padding(horizontal = 150.dp),
        )
    }
}


//@Preview(showBackground = true)
//@Composable
//fun RealEstateCardPreview() {
//    RealEstateCard(
//        realEstate = RealEstate(price = 232, id="dfhjd", type = "sdss", imageUrl = "dss"))
//}
