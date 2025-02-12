package com.mnhyim.gymetric.domain.repository

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.mnhyim.gymetric.data.entity.TrainingSetEntity
import com.mnhyim.gymetric.domain.model.TrainingSet
import kotlinx.coroutines.flow.Flow
import java.time.LocalDate

interface TrainingSetRepository {

    fun getAllTrainingSet()
    fun getTrainingSetByDates(startDate: LocalDate, endDate: LocalDate): Flow<List<TrainingSet>>
    suspend fun insertTrainingSet(trainingSet: TrainingSet)
    suspend fun deleteTrainingSet(trainingSet: TrainingSet)
}