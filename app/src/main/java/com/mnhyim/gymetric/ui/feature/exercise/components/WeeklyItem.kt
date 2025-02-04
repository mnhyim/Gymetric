package com.mnhyim.gymetric.ui.feature.exercise.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun WeeklyItem(
    date: Int,
    modifier: Modifier = Modifier
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .then(
                if (date == 4) {
                    Modifier.background(
                        MaterialTheme.colorScheme.primary.copy(alpha = 0.125f),
                        RoundedCornerShape(16.dp)
                    )
                } else Modifier
            )
            .clip(RoundedCornerShape(16.dp))
            .clickable { }
            .padding(8.dp, 16.dp)
    ) {
        Text(
            text = "Mon",
            style = MaterialTheme.typography.bodySmall,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
        )
        Text(
            text = "${date + 1}",
            style = MaterialTheme.typography.titleLarge,
            color = MaterialTheme.colorScheme.onPrimaryContainer,
            fontWeight = FontWeight.ExtraBold
        )
    }
}