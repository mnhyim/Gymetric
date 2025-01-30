package com.mnhyim.gymetric.domain.model

import java.time.LocalDate

data class ExerciseSet(
    val id: Long,
    val exerciseId: Long,
    val date: LocalDate
)