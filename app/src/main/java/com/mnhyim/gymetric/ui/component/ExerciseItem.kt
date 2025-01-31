package com.mnhyim.gymetric.ui.component

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp

@Composable
fun ExerciseItem(
    expanded: Boolean,
    onExpand: () -> Unit,
    modifier: Modifier = Modifier
) {
    OutlinedCard(
        colors = CardDefaults.outlinedCardColors(
            containerColor = MaterialTheme.colorScheme.surfaceContainerHighest
        ),
        border = BorderStroke(1.dp, Color.Transparent)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .padding(12.dp, 12.dp, 8.dp, 12.dp)
        ) {
            Column {
                Text(
                    text = "Chest",
                    style = MaterialTheme.typography.labelSmall,
                    modifier = Modifier
                        .padding(bottom = 4.dp)
                        .background(
                            MaterialTheme.colorScheme.surfaceContainerLow,
                            RoundedCornerShape(8.dp)
                        )
                        .padding(8.dp, 4.dp)
                )
                Text(
                    text = "Incline Bench Press",
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Bold
                )
            }
            Spacer(modifier = Modifier.weight(1f))
            IconButton(
                onClick = onExpand
            ) {
                Icon(
                    imageVector = if (expanded) Icons.Default.KeyboardArrowDown else Icons.Default.KeyboardArrowUp,
                    contentDescription = ""
                )
            }
        }
        AnimatedVisibility(
            visible = expanded
        ) {
            Column(
                modifier = Modifier
                    .padding(8.dp, 0.dp, 8.dp, 8.dp)
                    .border(
                        1.dp,
                        MaterialTheme.colorScheme.primary.copy(alpha = 0.25f),
                        RoundedCornerShape(8.dp)
                    )
            ) {
                ExerciseSetItemTitle(
                    modifier = Modifier.background(
                        MaterialTheme.colorScheme.surfaceContainerLow,
                        RoundedCornerShape(8.dp, 8.dp, 0.dp, 0.dp)
                    )
                )
                repeat(5) {
                    ExerciseSetItem(
                        modifier = Modifier.background(if (it % 2 == 1) MaterialTheme.colorScheme.surfaceContainerLow else Color.Unspecified)
                    )
                }
            }
        }
    }
}