package com.mnhyim.gymetric.ui.feature.settings.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ExerciseItem(
    modifier: Modifier = Modifier
) {
    var expanded by remember { mutableStateOf(false) }

    Card {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp, 8.dp, 8.dp, 8.dp)
        ) {
            Text(
                text = "Muscle Name",
                style = MaterialTheme.typography.titleMedium
            )
            IconButton(
                onClick = { expanded = !expanded }
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
                    .background(MaterialTheme.colorScheme.surfaceContainerHigh)
                    .fillMaxWidth()
                    .padding(16.dp, 4.dp, 16.dp, 4.dp)
            ) {
                repeat(10) {
                    if (it != 0) HorizontalDivider()
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Exercise Name",
                            style = MaterialTheme.typography.titleSmall
                        )
                        IconButton(
                            onClick = {}
                        ) {
                            Icon(
                                imageVector = Icons.Outlined.Delete,
                                contentDescription = ""
                            )
                        }
                    }
                }
            }
        }
    }

}