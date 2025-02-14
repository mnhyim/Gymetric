package com.mnhyim.gymetric.domain.model

import java.time.LocalDate

data class DateItem(
    val id: Int,
    val date: LocalDate,
    val isToday: Boolean
)