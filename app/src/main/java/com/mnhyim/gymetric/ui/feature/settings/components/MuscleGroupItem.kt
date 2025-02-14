package com.mnhyim.gymetric.ui.feature.settings.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mnhyim.gymetric.domain.model.MuscleGroup

@Composable
fun MuscleGroupItem(
    item: MuscleGroup,
    onDelete: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = modifier.fillMaxWidth()
        ) {
            Text(
                text = item.name,
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(16.dp, 16.dp, 0.dp, 16.dp)
            )
            IconButton(
                onClick = onDelete
            ) {
                Icon(
                    imageVector = Icons.Outlined.Delete,
                    contentDescription = ""
                )
            }
        }
    }
}