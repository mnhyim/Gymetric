package com.mnhyim.gymetric.domain.repository

import com.mnhyim.gymetric.domain.model.Exercise
import com.mnhyim.gymetric.domain.model.MuscleGroupWithExercise
import kotlinx.coroutines.flow.Flow

interface ExerciseRepository {

    fun getAllExercise(): Flow<List<MuscleGroupWithExercise>>
    suspend fun insertExercise(exercise: Exercise)
    suspend fun deleteExercise(exercise: Exercise)
}