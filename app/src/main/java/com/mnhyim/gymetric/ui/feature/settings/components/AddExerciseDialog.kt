package com.mnhyim.gymetric.ui.feature.settings.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.mnhyim.gymetric.domain.model.MuscleGroup
import com.mnhyim.gymetric.ui.components.CustomDropDown

@Composable
fun AddExerciseDialog(
    muscleGroups: List<MuscleGroup>,
    onDismiss: () -> Unit,
    onSave: (Long, String) -> Unit,
    modifier: Modifier = Modifier
) {
    var exerciseName by remember { mutableStateOf("") }
    var selectedMuscleGroup by remember { mutableLongStateOf(-1) }

    Dialog(onDismissRequest = onDismiss) {
        Card {
            Column(
                modifier = modifier
            ) {
                Text(
                    text = "Add Exercise",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                CustomDropDown(
                    items = muscleGroups,
                    selectedItemId = selectedMuscleGroup,
                    getItemId = { it.id },
                    getItemName = { it.name },
                    onSelect = { selectedMuscleGroup = it },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    label = {
                        Text(
                            text = "Muscle Group",
                            style = MaterialTheme.typography.bodySmall
                        )
                    },
                )
                OutlinedTextField(
                    value = exerciseName,
                    onValueChange = { exerciseName = it },
                    label = {
                        Text(
                            text = "Name",
                            style = MaterialTheme.typography.bodySmall
                        )
                    },
                    singleLine = true,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 16.dp)
                )
                Row(
                    horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()
                ) {
                    TextButton(onClick = onDismiss) {
                        Text("Cancel")
                    }
                    TextButton(onClick = {
                        onSave(
                            selectedMuscleGroup,
                            exerciseName,
                        )
                        exerciseName = ""
                    }) {
                        Text("Add")
                    }
                }
            }
        }
    }
}