package com.mnhyim.gymetric.domain.model

import java.time.LocalDate

data class TrainingSet(

    val id: Long,
    val set: Int,
    val reps: Int,
    val weight: Double,
    val notes: String? = "",
    val date: LocalDate,
    val time: Int,
    val exercise: Exercise,
)