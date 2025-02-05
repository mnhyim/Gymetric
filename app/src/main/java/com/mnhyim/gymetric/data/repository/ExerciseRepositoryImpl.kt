package com.mnhyim.gymetric.data.repository

import com.mnhyim.gymetric.data.dao.ExerciseDao
import com.mnhyim.gymetric.data.entity.MuscleGroupWithExercisesEntity
import com.mnhyim.gymetric.domain.model.Exercise
import com.mnhyim.gymetric.domain.model.MuscleGroup
import com.mnhyim.gymetric.domain.model.MuscleGroupWithExercise
import com.mnhyim.gymetric.domain.repository.ExerciseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ExerciseRepositoryImpl @Inject constructor(
    private val dao: ExerciseDao
) : ExerciseRepository {

    override fun getAllExercise(): Flow<List<MuscleGroupWithExercise>> {
        return dao.getAllExerciseWithM().map { exercises ->
            exercises.map { exercise ->
                MuscleGroupWithExercise(
                    muscleGroup = MuscleGroup(exercise.muscleGroup.id, exercise.muscleGroup.name),
                    exercises = exercise.exercises.map { a -> Exercise(a.id, a.name) }
                )
            }
        }
    }

    override suspend fun insertExercise(exercise: MuscleGroupWithExercise) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteExercise(exercise: MuscleGroupWithExercise) {
        TODO("Not yet implemented")
    }
}