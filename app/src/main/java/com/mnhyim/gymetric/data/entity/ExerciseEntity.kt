package com.mnhyim.gymetric.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "exercise")
data class ExerciseEntity(

    @ColumnInfo(name = "muscle_group_id") val muscleGroupId: Long,
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "exercise_id") val id: Long = 0,
    @ColumnInfo(name = "exercise_name") val name: String,
)