package com.mnhyim.gymetric.ui.feature.exercise

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.mnhyim.gymetric.ui.feature.exercise.components.ExerciseSessionItem
import com.mnhyim.gymetric.ui.feature.exercise.components.WeeklyDate

@Composable
fun ExerciseScreen(
    modifier: Modifier = Modifier
) {
    Scaffold(
        topBar = {
            WeeklyDate()
        },
        modifier = modifier
    ) { innerPadding ->
        ExerciseScreenContent(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp, 8.dp)
        )
    }
}

@Composable
private fun ExerciseScreenContent(
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = modifier
    ) {
        Text(
            text = "Today's Exercise",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 8.dp)
        )
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp),
            modifier = Modifier
        ) {
            items(5) {
                ExerciseSessionItem(
                    expanded = expanded,
                    onExpand = { expanded = !expanded }
                )
            }
        }
    }
}
