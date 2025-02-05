package com.mnhyim.gymetric.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.mnhyim.gymetric.data.entity.MuscleGroupEntity
import com.mnhyim.gymetric.data.entity.MuscleGroupWithExercisesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MuscleGroupDao {

    @Query("SELECT * FROM muscle_group")
    fun getAllMuscleGroup(): Flow<List<MuscleGroupEntity>>

    @Transaction
    @Query(
        " SELECT * FROM muscle_group mg" +
        " INNER JOIN exercise e ON mg.muscle_group_id = e.muscle_group_id" +
        " GROUP BY mg.muscle_group_id"
    )
    fun getAllMuscleGroupWithExercises(): Flow<List<MuscleGroupWithExercisesEntity>>

    @Insert
    suspend fun insertMuscleGroup(muscleGroup: MuscleGroupEntity)

    @Delete
    suspend fun deleteMuscleGroup(muscleGroup: MuscleGroupEntity)
}