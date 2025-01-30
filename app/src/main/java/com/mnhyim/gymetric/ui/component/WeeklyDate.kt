package com.mnhyim.gymetric.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeeklyDate(
    modifier: Modifier = Modifier
) {
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.clip(RoundedCornerShape(0.dp, 0.dp, 16.dp, 16.dp))
    ) {
        TopAppBar(
            title = {
                Column {
                    Text(
                        text = "Saturday",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Text(
                        text = "16 April 2025",
                        style = MaterialTheme.typography.bodySmall,
                    )
                }
            },
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.onPrimaryContainer
            )
        )
        Row(
            modifier = modifier
                .background(MaterialTheme.colorScheme.primaryContainer)
                .padding(16.dp, 8.dp, 16.dp, 16.dp)
        ) {
            repeat(7) {
                WeeklyItem(
                    date = it,
                    modifier = Modifier
                        .padding(horizontal = 4.dp)
                        .weight(1f)
                )
            }
        }
    }
}