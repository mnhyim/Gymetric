package com.mnhyim.gymetric.data.repository

import com.mnhyim.gymetric.data.dao.MuscleGroupDao
import com.mnhyim.gymetric.data.entity.MuscleGroupEntity
import com.mnhyim.gymetric.domain.model.MuscleGroup
import com.mnhyim.gymetric.domain.repository.MuscleGroupRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class MuscleGroupRepositoryImpl @Inject constructor(
    private val dao: MuscleGroupDao
) : MuscleGroupRepository {

    override fun getAllMuscleGroup(): Flow<List<MuscleGroup>> {
        return dao.getAllMuscleGroup().map { muscleGroups ->
            muscleGroups.map { muscleGroup ->
                MuscleGroup(id = muscleGroup.id, name = muscleGroup.name)
            }
        }
    }

    override suspend fun insertMuscleGroup(muscleGroup: MuscleGroup) {
        dao.insertMuscleGroup(
            muscleGroup = MuscleGroupEntity(
                id = muscleGroup.id,
                name = muscleGroup.name
            )
        )
    }

    override suspend fun deleteMuscleGroup(muscleGroup: MuscleGroup) {
        dao.deleteMuscleGroup(
            muscleGroup = MuscleGroupEntity(
                id = muscleGroup.id,
                name = muscleGroup.name
            )
        )
    }
}