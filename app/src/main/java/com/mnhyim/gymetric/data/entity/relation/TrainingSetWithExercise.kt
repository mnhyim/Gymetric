package com.mnhyim.gymetric.data.entity.relation

import androidx.room.Embedded
import androidx.room.Relation
import com.mnhyim.gymetric.data.entity.ExerciseEntity
import com.mnhyim.gymetric.data.entity.TrainingSetEntity

data class TrainingSetWithExercise(
    @Embedded
    val trainingSet: TrainingSetEntity,

    @Relation(
        parentColumn = "exercise_id",
        entityColumn = "exercise_id"
    )
    val exercise: ExerciseEntity
)