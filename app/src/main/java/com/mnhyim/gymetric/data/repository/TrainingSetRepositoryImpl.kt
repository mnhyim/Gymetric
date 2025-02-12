package com.mnhyim.gymetric.data.repository

import android.util.Log
import com.mnhyim.gymetric.data.dao.TrainingSetDao
import com.mnhyim.gymetric.data.entity.TrainingSetEntity
import com.mnhyim.gymetric.domain.model.Exercise
import com.mnhyim.gymetric.domain.model.TrainingSet
import com.mnhyim.gymetric.domain.repository.TrainingSetRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.time.ZoneOffset
import javax.inject.Inject

class TrainingSetRepositoryImpl @Inject constructor(
    private val dao: TrainingSetDao
) : TrainingSetRepository {

    override fun getAllTrainingSet() {
        TODO("Not yet implemented")
    }

    override fun getTrainingSetByDates(
        startDate: LocalDate,
        endDate: LocalDate
    ): Flow<List<TrainingSet>> {
        val x = startDate.atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli()
        val y = endDate.atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli()
        Log.d("${this::class.simpleName}", "startDate:$startDate - $x")
        Log.d("${this::class.simpleName}", "endDate:$endDate - $y")
        return dao.getTrainingSetByDates(startDate = x, endDate = y).map { trainingSets ->
            Log.d("${this::class.simpleName}", "res: $trainingSets")
            trainingSets.map { trainingSet ->
                TrainingSet(
                    id = trainingSet.trainingSet.id,
                    set = trainingSet.trainingSet.set,
                    reps = trainingSet.trainingSet.reps,
                    weight = trainingSet.trainingSet.weight,
                    notes = trainingSet.trainingSet.notes,
                    date = Instant.ofEpochMilli(trainingSet.trainingSet.date)
                        .atZone(ZoneId.systemDefault()).toLocalDate(),
                    time = trainingSet.trainingSet.time,
                    exercise = Exercise(
                        exerciseId = trainingSet.exercise.id,
                        exerciseName = trainingSet.exercise.name
                    )
                )
            }

        }
    }

    override suspend fun insertTrainingSet(trainingSet: TrainingSet) {
        dao.insertTrainingSet(
            TrainingSetEntity(
                id = trainingSet.id,
                set = trainingSet.set,
                reps = trainingSet.reps,
                weight = trainingSet.weight,
                notes = trainingSet.notes,
                date = trainingSet.date.atStartOfDay(ZoneOffset.UTC).toInstant().toEpochMilli(),
                time = trainingSet.time,
                exerciseId = trainingSet.exercise.exerciseId
            )
        )
    }

    override suspend fun deleteTrainingSet(trainingSet: TrainingSet) {
        TODO("Not yet implemented")
    }
}