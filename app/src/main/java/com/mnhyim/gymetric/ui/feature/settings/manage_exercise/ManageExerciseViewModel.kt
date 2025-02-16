package com.mnhyim.gymetric.ui.feature.settings.manage_exercise

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mnhyim.gymetric.domain.model.Exercise
import com.mnhyim.gymetric.domain.model.ExercisesByMuscleGroup
import com.mnhyim.gymetric.domain.model.MuscleGroup
import com.mnhyim.gymetric.domain.repository.ExerciseRepository
import com.mnhyim.gymetric.domain.repository.MuscleGroupRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ManageExerciseViewModel @Inject constructor(
    private val muscleGroupRepository: MuscleGroupRepository,
    private val exerciseRepository: ExerciseRepository
) : ViewModel() {

    private var _muscleGroups = MutableStateFlow(emptyList<MuscleGroup>())
    val muscleGroups = _muscleGroups.asStateFlow()

    private var _exercises = MutableStateFlow(emptyList<ExercisesByMuscleGroup>())
    val exercises = _exercises.asStateFlow()

    init {
        viewModelScope.launch {
            muscleGroupRepository.getAllMuscleGroup().collect {
                _muscleGroups.value = it.map { MuscleGroup(id = it.id, name = it.name) }
            }
        }
        viewModelScope.launch {
            exerciseRepository.getAllExercisesByMuscleGroup().collect {
                _exercises.value = it
            }
        }
    }

    fun insert(muscleGroupId: Long, exerciseName: String) {
        viewModelScope.launch {
            exerciseRepository.insertExercise(
                Exercise(
                    exerciseId = 0,
                    exerciseName = exerciseName,
                ),
                muscleGroupId = muscleGroupId,
            )
        }
    }

    fun delete(exercise: Exercise, muscleGroupId: Long) {
        viewModelScope.launch {
            exerciseRepository.deleteExercise(exercise, muscleGroupId)
        }
    }
}