package com.mnhyim.gymetric.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.mnhyim.gymetric.data.entity.MuscleGroupEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MuscleGroupDao {

    @Query("SELECT * FROM muscle_group")
    fun getAllMuscleGroup(): Flow<List<MuscleGroupEntity>>

    @Insert
    suspend fun insertMuscleGroup(muscleGroup: MuscleGroupEntity)

    @Delete
    suspend fun deleteMuscleGroup(muscleGroup: MuscleGroupEntity)
}