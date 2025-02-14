package com.mnhyim.gymetric.ui.feature.exercise

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mnhyim.gymetric.domain.model.DateItem
import com.mnhyim.gymetric.domain.model.Exercise
import com.mnhyim.gymetric.domain.model.TrainingSet
import com.mnhyim.gymetric.domain.repository.TrainingSetRepository
import com.mnhyim.gymetric.util.CalendarUtil
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.time.LocalDate
import javax.inject.Inject

@HiltViewModel
class ExerciseViewModel @Inject constructor(
    private val trainingSetRepository: TrainingSetRepository
) : ViewModel() {

    private val calendarUtil = CalendarUtil()

    private var _trainingSet = MutableStateFlow(emptyMap<Exercise, List<TrainingSet>>())
    val trainingSet = _trainingSet.asStateFlow()

    private var _weekDates = MutableStateFlow(emptyList<DateItem>())
    val weekDates = _weekDates.asStateFlow()

    init {
        getCurrentWeekDates(offset = 0)
        getTrainingSetByDay(LocalDate.now())
    }

    fun getCurrentWeekDates(offset: Long) {
        _weekDates.value = calendarUtil.getCurrentWeekDates(offset)
    }

    fun getTrainingSetByDay(date: LocalDate) {
        viewModelScope.launch {
            trainingSetRepository.getTrainingSetByDates(
                startDate = LocalDate.of(2025, 2, 3),
                endDate = LocalDate.of(2025, 2, 16)
            ).collect {
                _trainingSet.value = it
                    .filter { it.date == date }
                    .groupBy { it.exercise }
            }
        }
    }

    fun insert() {
//        viewModelScope.launch {
//            trainingSetRepository.insertTrainingSet(
//                TrainingSet(
//                    id = 0,
//                    set = 1,
//                    reps = 1,
//                    weight = 2.0,
//                    notes = "A2",
//                    date = x,
//                    time = Random.nextInt(0, 150),
//                    exercise = Exercise(
//                        1,
//                        "E1MG1"
//                    )
//                )
//            )
//        }
    }
}