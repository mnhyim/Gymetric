package com.mnhyim.gymetric.data.entity.relation

import com.mnhyim.gymetric.data.entity.MuscleGroupEntity
import java.time.LocalDate

data class TrainingSet(
    val date: LocalDate,
    val muscleGroup: MuscleGroupEntity,

)