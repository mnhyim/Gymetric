package com.mnhyim.gymetric.domain.repository

import com.mnhyim.gymetric.domain.model.MuscleGroup
import kotlinx.coroutines.flow.Flow

interface MuscleGroupRepository {

    fun getAllMuscleGroup(): Flow<List<MuscleGroup>>
    suspend fun insertMuscleGroup(muscleGroup: MuscleGroup)
    suspend fun deleteMuscleGroup(muscleGroup: MuscleGroup)
}