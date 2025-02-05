package com.mnhyim.gymetric.domain.model

data class MuscleGroupWithExercise(
    val muscleGroup: MuscleGroup,
    val exercises: List<Exercise>
)