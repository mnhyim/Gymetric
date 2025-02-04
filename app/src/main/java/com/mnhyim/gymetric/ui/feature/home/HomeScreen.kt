package com.mnhyim.gymetric.ui.feature.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        modifier = modifier
    ) { innerPadding ->
        HomeScreenContent(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        )
    }
}

@Composable
private fun HomeScreenContent(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Card {
            Row(
                modifier = Modifier
                    .padding(16.dp)
                    .fillMaxWidth()
            ) {

            }
        }
    }
}