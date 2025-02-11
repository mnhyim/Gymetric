package com.mnhyim.gymetric.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.mnhyim.gymetric.data.entity.ExerciseEntity
import com.mnhyim.gymetric.data.entity.ExercisesByMuscleGroupEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ExerciseDao {

    @Query("SELECT * FROM exercise")
    fun getAllExercise(): Flow<List<ExerciseEntity>>

    @Transaction
    @Query(
        " SELECT * FROM muscle_group mg" +
                " INNER JOIN exercise e ON mg.muscle_group_id = e.muscle_group_id" +
                " GROUP BY mg.muscle_group_id"
    )
    fun getAllExercisesByMuscleGroup(): Flow<List<ExercisesByMuscleGroupEntity>>

    @Insert
    suspend fun insertExercise(exercise: ExerciseEntity)

    @Delete
    suspend fun deleteExercise(exercise: ExerciseEntity)
}