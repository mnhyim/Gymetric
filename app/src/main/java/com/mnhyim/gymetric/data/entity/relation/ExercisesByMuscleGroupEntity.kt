package com.mnhyim.gymetric.data.entity.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.mnhyim.gymetric.data.entity.ExerciseEntity
import com.mnhyim.gymetric.data.entity.MuscleGroupEntity

data class ExercisesByMuscleGroupEntity(

    @Embedded
    val muscleGroup: MuscleGroupEntity,

    @Relation(parentColumn = "muscle_group_id", entityColumn = "muscle_group_id")
    val exercises: List<ExerciseEntity>
)