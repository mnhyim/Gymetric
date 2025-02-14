package com.mnhyim.gymetric.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "training_set")
data class TrainingSetEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "training_set_id")
    val id: Long,

    @ColumnInfo(name = "training_set_count")
    val set: Int,

    @ColumnInfo(name = "training_set_reps")
    val reps: Int,

    @ColumnInfo(name = "training_set_weight")
    val weight: Double,

    @ColumnInfo(name = "training_set_notes")
    val notes: String?,

    @ColumnInfo(name = "training_set_date")
    val date: Long,

    @ColumnInfo(name = "training_set_time")
    val time: Int,

    @ColumnInfo(name = "exercise_id")
    val exerciseId: Long
)
