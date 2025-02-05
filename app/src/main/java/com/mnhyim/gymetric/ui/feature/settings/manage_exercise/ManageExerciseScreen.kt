package com.mnhyim.gymetric.ui.feature.settings.manage_exercise

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mnhyim.gymetric.domain.model.Exercise
import com.mnhyim.gymetric.domain.model.MuscleGroupWithExercise
import com.mnhyim.gymetric.ui.feature.settings.components.AddExerciseDialog
import com.mnhyim.gymetric.ui.feature.settings.components.ExerciseItem

@Composable
fun ManageExerciseScreen(
    viewModel: ManageExerciseViewModel = hiltViewModel(),
    modifier: Modifier = Modifier
) {
    var showModal by remember { mutableStateOf(false) }

    val muscleGroups by viewModel.muscleGroups.collectAsStateWithLifecycle()
    val exercises by viewModel.exercises.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {

        },
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
            AddExerciseDialog(
                muscleGroups = muscleGroups,
                onSave = { muscleGroupId, exerciseName ->
                    viewModel.insert(
                        muscleGroupId,
                        exerciseName
                    )
                },
                onDismiss = { showModal = false },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(24.dp),
            )
        }
        ManageExerciseScreenContent(
            exercises = exercises,
            onExerciseDelete = { viewModel.delete(it) },
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp, 0.dp, 16.dp, 16.dp)
        )
    }
}

@Composable
private fun ManageExerciseScreenContent(
    exercises: List<MuscleGroupWithExercise>,
    onExerciseDelete: (Exercise) -> Unit,
    modifier: Modifier = Modifier
) {

    Column(
        modifier = modifier
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            items(items = exercises) { muscleGroup: MuscleGroupWithExercise ->
                ExerciseItem(
                    muscleGroup = muscleGroup,
                    onDelete = { onExerciseDelete(it) }
                )
            }
        }
    }
}