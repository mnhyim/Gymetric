package com.mnhyim.gymetric.ui.feature.exercise

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
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
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.mnhyim.gymetric.domain.model.Exercise
import com.mnhyim.gymetric.domain.model.MuscleGroup
import com.mnhyim.gymetric.domain.model.TrainingSet
import com.mnhyim.gymetric.ui.feature.exercise.components.AddSetDialog
import com.mnhyim.gymetric.ui.feature.exercise.components.WeeklyDate
import java.time.LocalDate

@Composable
fun ExerciseScreen(
    modifier: Modifier = Modifier,
    viewModel: ExerciseViewModel = hiltViewModel()
) {
    var selectedDate by remember { mutableStateOf<LocalDate>(LocalDate.now()) }
    var showDialog by remember { mutableStateOf(false) }

    val trainingSet by viewModel.trainingSet.collectAsStateWithLifecycle()
    val weekDates by viewModel.weekDates.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            WeeklyDate(
                dates = weekDates,
                selectedDate = selectedDate,
                onClick = {
                    selectedDate = it
                    viewModel.getTrainingSetByDay(date = it)
                },
                onNext = { viewModel.getCurrentWeekDates(offset = 1) },
                onPrev = { viewModel.getCurrentWeekDates(offset = -1) },
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = { showDialog = true },
                shape = CircleShape
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = ""
                )
            }
        },
        modifier = modifier
    ) { innerPadding ->
        if (showDialog) {
            AddSetDialog(
                muscleGroups = emptyList(),
                exercises = emptyList(),
                onDismiss = { showDialog = false },
                modifier = Modifier
            )
        }
        ExerciseScreenContent(
            trainingSet = trainingSet,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(16.dp, 8.dp)
        )
    }
}

@Composable
private fun ExerciseScreenContent(
    trainingSet: Map<Exercise, List<TrainingSet>>,
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
            items(count = trainingSet.size) {
                HorizontalDivider()
                Text(trainingSet.keys.first().exerciseName)
                trainingSet.values.first().forEach {
                    Text("${it.set} - ${it.weight} - ${it.date} - ${it.exercise.exerciseId}")
                }
                HorizontalDivider()
            }
        }
    }
}
