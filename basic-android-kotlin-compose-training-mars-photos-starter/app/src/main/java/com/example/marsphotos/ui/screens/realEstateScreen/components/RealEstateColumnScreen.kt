package com.example.marsphotos.ui.screens.realEstateScreen.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.marsphotos.network.RealEstate

@Composable
fun RealEstateColumnScreen(
    realEstates: List<RealEstate>,
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    LazyColumn(
    ) {
        items(items = realEstates, key = { realEstate -> realEstate.id }) { realEstate ->
            RealEstateCard(
                realEstate,
                navController = navController,
                modifier = modifier
                    .padding(4.dp)
                    .fillMaxWidth()
            )
        }
    }
}