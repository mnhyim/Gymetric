package com.mnhyim.gymetric.domain.repository

import com.mnhyim.gymetric.domain.model.Exercise
import com.mnhyim.gymetric.domain.model.ExercisesByMuscleGroup
import kotlinx.coroutines.flow.Flow

interface ExerciseRepository {

    fun getAllExercises(): Flow<List<Exercise>>
    fun getAllExercisesByMuscleGroup(): Flow<List<ExercisesByMuscleGroup>>
    suspend fun insertExercise(exercise: Exercise, muscleGroupId: Long)
    suspend fun deleteExercise(exercise: Exercise, muscleGroupId: Long)
}