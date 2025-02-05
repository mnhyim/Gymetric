package com.mnhyim.gymetric.data.repository

import com.mnhyim.gymetric.data.dao.ExerciseDao
import com.mnhyim.gymetric.data.dao.MuscleGroupDao
import com.mnhyim.gymetric.data.entity.ExerciseEntity
import com.mnhyim.gymetric.domain.model.Exercise
import com.mnhyim.gymetric.domain.model.MuscleGroup
import com.mnhyim.gymetric.domain.model.MuscleGroupWithExercise
import com.mnhyim.gymetric.domain.repository.ExerciseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ExerciseRepositoryImpl @Inject constructor(
    private val dao: MuscleGroupDao,
    private val dao2: ExerciseDao
) : ExerciseRepository {

    override fun getAllExercise(): Flow<List<MuscleGroupWithExercise>> {
        return dao.getAllMuscleGroupWithExercises().map { exercises ->
            exercises.map { exercise ->
                MuscleGroupWithExercise(
                    muscleGroup = MuscleGroup(exercise.muscleGroup.id, exercise.muscleGroup.name),
                    exercises = exercise.exercises.map { a ->
                        Exercise(
                            muscleGroupId = a.muscleGroupId,
                            exerciseId = a.id,
                            exerciseName = a.name,
                        )
                    }
                )
            }
        }
    }

    override suspend fun insertExercise(exercise: Exercise) {
        dao2.insertExercise(
            ExerciseEntity(muscleGroupId = exercise.muscleGroupId, name = exercise.exerciseName)
        )
    }

    override suspend fun deleteExercise(exercise: Exercise) {
        dao2.deleteExercise(
            ExerciseEntity(muscleGroupId = exercise.muscleGroupId, id = exercise.exerciseId, name = exercise.exerciseName)
        )
    }
}