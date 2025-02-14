package com.mnhyim.gymetric.ui.feature.exercise.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import com.mnhyim.gymetric.domain.model.Exercise
import com.mnhyim.gymetric.domain.model.MuscleGroup
import com.mnhyim.gymetric.domain.model.TrainingSet
import com.mnhyim.gymetric.ui.components.CustomDropDown
import java.time.LocalDate
import java.time.LocalTime

@Composable
fun AddSetDialog(
    muscleGroups: List<MuscleGroup>,
    exercises: List<Exercise>,
    onDismiss: () -> Unit,
    onAddSet: (TrainingSet) -> Unit,
    getExercises: (Long) -> Unit,
    modifier: Modifier = Modifier
) {
    var selectedMuscleGroupId by remember { mutableLongStateOf(-1) }
    var selectedExerciseId by remember { mutableLongStateOf(-1) }

    var setReps by remember { mutableStateOf("") }
    var setWeight by remember { mutableStateOf("") }
    var setNotes by remember { mutableStateOf("") }

    LaunchedEffect(selectedMuscleGroupId) {
        getExercises(selectedMuscleGroupId)
    }

    Dialog(
        onDismissRequest = onDismiss,
    ) {
        Card(
            modifier = modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier.padding(16.dp)
            ) {
                Text(
                    text = "Add Set",
                    style = MaterialTheme.typography.titleMedium,
                    modifier = Modifier.padding(bottom = 16.dp)
                )

                CustomDropDown(
                    items = muscleGroups,
                    selectedItemId = selectedMuscleGroupId,
                    getItemId = { it.id },
                    getItemName = { it.name },
                    onSelect = {
                        selectedMuscleGroupId = it
                    },
                    modifier = Modifier.padding(bottom = 8.dp),
                    label = {
                        Text(
                            text = "Muscle Group",
                            style = MaterialTheme.typography.titleSmall
                        )
                    },
                )

                CustomDropDown(
                    items = exercises,
                    selectedItemId = selectedExerciseId,
                    getItemId = { it.exerciseId },
                    getItemName = { it.exerciseName },
                    onSelect = { selectedExerciseId = it },
                    modifier = Modifier.padding(bottom = 8.dp),
                    label = {
                        Text(
                            text = "Exercise",
                            style = MaterialTheme.typography.titleSmall
                        )
                    },
                )

                Row(
                    modifier = Modifier.padding(bottom = 8.dp)
                ) {
                    OutlinedTextField(
                        value = setReps,
                        onValueChange = {
                            if (it.isEmpty() || it.all { it.isDigit() }) {
                                setReps = if (it.length <= 3) it else setReps
                            }
                        },
                        label = {
                            Text(
                                text = "Reps",
                                style = MaterialTheme.typography.titleSmall
                            )
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Number),
                        modifier = Modifier
                            .fillMaxWidth(0.5f)
                            .padding(end = 8.dp)
                    )
                    OutlinedTextField(
                        value = setWeight,
                        onValueChange = {
                            if (it.isEmpty() || it.toDoubleOrNull() != null) {
                                setWeight = if (it.length <= 6) it else setWeight
                            }
                        },
                        label = {
                            Text(
                                text = "Weight",
                                style = MaterialTheme.typography.titleSmall
                            )
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Decimal),
                        modifier = Modifier.fillMaxWidth(1f)
                    )
                }

                OutlinedTextField(
                    value = setNotes,
                    onValueChange = { setNotes = it },
                    label = {
                        Text(
                            text = "Notes",
                            style = MaterialTheme.typography.titleSmall
                        )
                    },
                    minLines = 3,
                    maxLines = 3,
                    modifier = Modifier
                        .fillMaxWidth(1f)
                        .padding(bottom = 16.dp)
                )

                Row(
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    TextButton(onClick = onDismiss) {
                        Text("Cancel")
                    }
                    TextButton(
                        onClick = {
                            onAddSet(
                                TrainingSet(
                                    reps = setReps.toInt(),
                                    weight = setWeight.toDouble(),
                                    notes = setNotes,
                                    date = LocalDate.now(),
                                    time = LocalTime.now().toSecondOfDay(),
                                    exercise = exercises.first { it.exerciseId == selectedExerciseId }
                                )
                            )
                        }
                    ) {
                        Text("Add")
                    }
                }
            }
        }
    }
}