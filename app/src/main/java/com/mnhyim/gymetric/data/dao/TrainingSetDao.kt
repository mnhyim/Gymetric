package com.mnhyim.gymetric.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.mnhyim.gymetric.data.entity.TrainingSetEntity
import com.mnhyim.gymetric.data.entity.relation.TrainingSetWithExercise
import kotlinx.coroutines.flow.Flow

@Dao
interface TrainingSetDao {

//    fun getAllTrainingSet()

    @Query("SELECT * FROM training_set WHERE training_set_date BETWEEN :startDate AND :endDate")
    fun getTrainingSetByDates(startDate: Long, endDate: Long): Flow<List<TrainingSetWithExercise>>

    @Insert
    suspend fun insertTrainingSet(trainingSet: TrainingSetEntity)

    @Delete
    suspend fun deleteTrainingSet(trainingSet: TrainingSetEntity)
}