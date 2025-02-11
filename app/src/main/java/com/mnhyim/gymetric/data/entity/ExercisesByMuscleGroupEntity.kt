package com.mnhyim.gymetric.data.entity

import androidx.room.Embedded
import androidx.room.Relation

data class ExercisesByMuscleGroupEntity(

    @Embedded
    val muscleGroup: MuscleGroupEntity,

    @Relation(parentColumn = "muscle_group_id", entityColumn = "muscle_group_id")
    val exercises: List<ExerciseEntity>
)