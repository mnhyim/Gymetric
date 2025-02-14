package com.mnhyim.gymetric.ui.feature.exercise

import android.util.Log
import androidx.compose.ui.text.font.FontWeight
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mnhyim.gymetric.domain.model.DateItem
import com.mnhyim.gymetric.domain.model.Exercise
import com.mnhyim.gymetric.domain.model.ExercisesByMuscleGroup
import com.mnhyim.gymetric.domain.model.MuscleGroup
import com.mnhyim.gymetric.domain.model.TrainingSet
import com.mnhyim.gymetric.domain.repository.ExerciseRepository
import com.mnhyim.gymetric.domain.repository.MuscleGroupRepository
import com.mnhyim.gymetric.domain.repository.TrainingSetRepository
import com.mnhyim.gymetric.util.CalendarUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import java.time.LocalTime
import javax.inject.Inject

@HiltViewModel
class ExerciseViewModel @Inject constructor(
    private val muscleGroupRepository: MuscleGroupRepository,
    private val exerciseRepository: ExerciseRepository,
    private val trainingSetRepository: TrainingSetRepository
) : ViewModel() {

    private val calendarUtil = CalendarUtil()

    private var _weekDates = MutableStateFlow(emptyList<DateItem>())
    val weekDates = _weekDates.asStateFlow()

    private var _muscleGroups = MutableStateFlow(emptyList<MuscleGroup>())
    val muscleGroups = _muscleGroups.asStateFlow()

    private var _exercises = MutableStateFlow(emptyList<Exercise>())
    val exercises = _exercises.asStateFlow()

    private var _trainingSet = MutableStateFlow(emptyMap<Exercise, List<TrainingSet>>())
    val trainingSet = _trainingSet.asStateFlow()

    init {
        getCurrentWeekDates(offset = 0)
        getTrainingSetByDay(LocalDate.now())

        viewModelScope.launch {
            muscleGroupRepository.getAllMuscleGroup().collect {
                _muscleGroups.value = it
            }
        }
        getExercises()
    }

    fun getCurrentWeekDates(offset: Long) {
        _weekDates.value = calendarUtil.getCurrentWeekDates(offset)
    }

    fun getTrainingSetByDay(date: LocalDate) {
        viewModelScope.launch {
            trainingSetRepository.getTrainingSetByDates(
                startDate = LocalDate.of(2025, 2, 3),
                endDate = LocalDate.of(2025, 2, 16)
            ).collect {
                _trainingSet.value = it
                    .filter { it.date == date }
                    .groupBy { it.exercise }
            }
        }
    }

    fun getExercises(muscleGroupId: Long? = null) {
        viewModelScope.launch {
            exerciseRepository.getAllExercisesByMuscleGroup().collect{
                _exercises.value = it
                    .filter { it.muscleGroup.id == muscleGroupId }
                    .flatMap { it.exercises.map { Exercise(exerciseId = it.exerciseId, exerciseName = it.exerciseName) } }
                    .ifEmpty { emptyList() }
            }
        }
    }

    fun insert(
        set: TrainingSet
    ) {
        viewModelScope.launch {
            trainingSetRepository.insertTrainingSet(set)
        }
    }
}