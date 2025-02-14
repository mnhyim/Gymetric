package com.mnhyim.gymetric.util

import com.mnhyim.gymetric.domain.model.DateItem
import java.time.DayOfWeek
import java.time.LocalDate
import java.time.temporal.TemporalAdjusters

class CalendarUtil {

    private var currentDate = LocalDate.now()
    private var currentStartDate = currentDate

    fun getCurrentWeekDates(
        offset: Long
    ): MutableList<DateItem> {
        val res = mutableListOf<DateItem>()

        for (i in 0..6) {
            val date = currentStartDate.plusWeeks(offset)
                .with(TemporalAdjusters.previousOrSame(DayOfWeek.SUNDAY))
                .plusDays(i.toLong())

            res.add(
                DateItem(
                    id = i,
                    date = date,
                    isToday = LocalDate.now() == date
                )
            )
        }

        currentStartDate = res[6].date

        return res
    }
}