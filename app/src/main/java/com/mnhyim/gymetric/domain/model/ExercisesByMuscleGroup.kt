package com.mnhyim.gymetric.domain.model

data class ExercisesByMuscleGroup(
    val muscleGroup: MuscleGroup,
    val exercises: List<Exercise>
)
