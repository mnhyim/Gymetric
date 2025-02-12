package com.mnhyim.gymetric.ui.feature.exercise

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mnhyim.gymetric.domain.model.Exercise
import com.mnhyim.gymetric.domain.model.MuscleGroup
import com.mnhyim.gymetric.domain.model.TrainingSet
import com.mnhyim.gymetric.domain.repository.TrainingSetRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import javax.inject.Inject
import kotlin.random.Random

@HiltViewModel
class ExerciseViewModel @Inject constructor(
    private val trainingSetRepository: TrainingSetRepository
): ViewModel() {

    private var _trainingSet = MutableStateFlow(emptyList<TrainingSet>())
    val trainingSet = _trainingSet.asStateFlow()

    init {
        viewModelScope.launch {
            trainingSetRepository.getTrainingSetByDates(startDate = LocalDate.of(2025,2,3), endDate = LocalDate.of(2025,2,16)).collect {
                _trainingSet.value = it
            }
        }
    }

    fun insert() {
        val timestamps = listOf(
            1738531200000, // Feb 3, 2025
            1738617600000, // Feb 4, 2025
            1738704000000, // Feb 5, 2025
            1738790400000, // Feb 6, 2025
            1738876800000, // Feb 7, 2025
            1738963200000, // Feb 8, 2025
            1739049600000, // Feb 9, 2025
            1739136000000, // Feb 10, 2025
            1739222400000, // Feb 11, 2025
            1739308800000, // Feb 12, 2025
            1739395200000, // Feb 13, 2025
            1739481600000, // Feb 14, 2025
            1739568000000, // Feb 15, 2025
            1739654400000  // Feb 16, 2025
        )
        val x = Instant.ofEpochMilli(timestamps.random()).atZone(ZoneId.systemDefault()).toLocalDate()
        viewModelScope.launch {
            trainingSetRepository.insertTrainingSet(
                TrainingSet(
                    id = 0,
                    set = 1,
                    reps = 1,
                    weight = 2.0,
                    notes = "A",
                    date = x,
                    time = Random.nextInt(0,150),
                    exercise = Exercise(
                        1,
                        "E1MG1"
                    )
                )
            )
        }
    }
}