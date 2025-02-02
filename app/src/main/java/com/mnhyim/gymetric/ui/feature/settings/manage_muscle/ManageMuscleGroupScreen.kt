package com.mnhyim.gymetric.ui.feature.settings.manage_muscle

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.outlined.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.mnhyim.gymetric.domain.model.MuscleGroup

@Composable
fun ManageMuscleGroupScreen(
    modifier: Modifier = Modifier
) {
    var showModal by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {},
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showModal = true },
                shape = CircleShape
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = ""
                )
            }
        }
    ) { innerPadding ->
        if (showModal) {
            Dialog(onDismissRequest = { showModal = false }) {
                Card {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                    ) {
                        Text(
                            text = "Add Category",
                            style = MaterialTheme.typography.titleMedium,
                            modifier = Modifier
                        )
                        OutlinedTextField(
                            value = "",
                            onValueChange = {},
                            label = {
                                Text(
                                    text = "Name"
                                )
                            },
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 16.dp)
                        )
                        Row(
                            horizontalArrangement = Arrangement.End,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            TextButton(
                                onClick = {}
                            ) {
                                Text("Cancel")
                            }
                            TextButton(
                                onClick = {}
                            ) {
                                Text("Add")
                            }
                        }
                    }
                }
            }
        }

        ManageMuscleGroupScreenContent(
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        )
    }
}

@Composable
private fun ManageMuscleGroupScreenContent(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(10) {
                MuscleGroupItem(
                    item = MuscleGroup(0, "Chest $it")
                )
            }
        }
    }
}

@Composable
fun MuscleGroupItem(
    item: MuscleGroup,
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