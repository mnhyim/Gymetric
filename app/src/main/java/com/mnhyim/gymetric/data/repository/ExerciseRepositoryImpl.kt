package com.mnhyim.gymetric.data.repository

import com.mnhyim.gymetric.data.dao.ExerciseDao
import com.mnhyim.gymetric.data.entity.ExerciseEntity
import com.mnhyim.gymetric.domain.model.Exercise
import com.mnhyim.gymetric.domain.model.ExercisesByMuscleGroup
import com.mnhyim.gymetric.domain.model.MuscleGroup
import com.mnhyim.gymetric.domain.repository.ExerciseRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class ExerciseRepositoryImpl @Inject constructor(
    private val dao: ExerciseDao
) : ExerciseRepository {

    override fun getAllExercise(): Flow<List<Exercise>> {
        TODO("Not yet implemented")
    }

    override fun getAllExercisesByMuscleGroup(): Flow<List<ExercisesByMuscleGroup>> {
        return dao.getAllExercisesByMuscleGroup().map { exercises ->
            exercises.map { exercise ->
                ExercisesByMuscleGroup(
                    muscleGroup = MuscleGroup(exercise.muscleGroup.id, exercise.muscleGroup.name),
                    exercises = exercise.exercises.map { a ->
                        Exercise(
                            exerciseId = a.id,
                            exerciseName = a.name,
                        )
                    }
                )
            }
        }
    }

    override suspend fun insertExercise(exercise: Exercise, muscleGroupId: Long) {
        dao.insertExercise(
            ExerciseEntity(
                id = exercise.exerciseId,
                name = exercise.exerciseName,
                muscleGroupId = muscleGroupId,
            )
        )
    }

    override suspend fun deleteExercise(exercise: Exercise, muscleGroupId: Long) {
        dao.deleteExercise(
            ExerciseEntity(
                id = exercise.exerciseId,
                name = exercise.exerciseName,
                muscleGroupId = muscleGroupId
            )
        )
    }
}