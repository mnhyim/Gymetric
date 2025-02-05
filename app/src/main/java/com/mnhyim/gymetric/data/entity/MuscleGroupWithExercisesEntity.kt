package com.mnhyim.gymetric.data.entity

import androidx.room.Embedded
import androidx.room.Relation

data class MuscleGroupWithExercisesEntity(
    @Embedded val muscleGroup: MuscleGroupEntity,
    @Relation(parentColumn = "muscle_group_id", entityColumn = "exercise_id")
    val exercises: List<ExerciseEntity>
)