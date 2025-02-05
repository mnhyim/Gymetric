package com.mnhyim.gymetric.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.mnhyim.gymetric.data.entity.ExerciseEntity
import com.mnhyim.gymetric.data.entity.MuscleGroupEntity
import com.mnhyim.gymetric.data.entity.MuscleGroupWithExercisesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface ExerciseDao {

    @Query("SELECT * FROM exercise")
    fun getAllExercise(): Flow<List<ExerciseEntity>>

    @Transaction
    @Query("SELECT * FROM muscle_group")
    fun getAllExerciseWithM(): Flow<List<MuscleGroupWithExercisesEntity>>

    @Insert
    suspend fun insertMuscleGroup(muscleGroup: MuscleGroupEntity)

    @Delete
    suspend fun deleteMuscleGroup(muscleGroup: MuscleGroupEntity)
}