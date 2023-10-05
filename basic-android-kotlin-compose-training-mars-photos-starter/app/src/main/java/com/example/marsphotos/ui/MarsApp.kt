/*
 * Copyright (C) 2023 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

@file:OptIn(ExperimentalMaterial3Api::class)

package com.example.marsphotos.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import com.example.marsphotos.ui.screens.marsPhotosScreen.MarsViewModel
import com.example.marsphotos.ui.screens.realEstateScreen.RealEstateScreen
import com.example.marsphotos.ui.screens.realEstateScreen.RealEstateVIewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun MarsApp() {
    // val marsViewModel = MarsViewModel(GetMarsPhotosUseCase(GetMarsPhotosRepository(retrofitPhotosService)))
    val marsViewModel: MarsViewModel = koinViewModel()
    val realEstateViewModel: RealEstateVIewModel = koinViewModel()

    val scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    Scaffold(modifier = Modifier.nestedScroll(scrollBehavior.nestedScrollConnection),
        topBar = { MarsTopAppBar(scrollBehavior = scrollBehavior) },
        bottomBar = { BottomNavigation() }) {
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(it)
        ) {
//            HomeScreen(
//                marsUiState = marsViewModel.marsUiState
//            )
            RealEstateScreen(
                realEstateUiState = realEstateViewModel.realEstateUiState
            )
       }
    }
}

@Composable
private fun BottomNavigation(modifier: Modifier = Modifier) {
    NavigationBar(
        containerColor = MaterialTheme.colorScheme.surfaceVariant,
        modifier = modifier
    ) {
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null
                )
            },
            label = {
                Text("Real Estate")
            },
            selected = true,
            onClick = {}
        )
        NavigationBarItem(
            icon = {
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = null
                )
            },
            label = {
                Text("Mars Photos")
            },
            selected = false,
            onClick = {}
        )
    }
}

@Composable
fun MarsTopAppBar(scrollBehavior: TopAppBarScrollBehavior, modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        scrollBehavior = scrollBehavior, title = {
            Text(
                text = "Mars App",
                style = MaterialTheme.typography.headlineSmall,
            )
        }, modifier = modifier
    )
}
