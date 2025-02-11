package com.mnhyim.gymetric.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    tableName = "exercise",
    foreignKeys = [ForeignKey(
        entity = MuscleGroupEntity::class,
        parentColumns = ["muscle_group_id"],
        childColumns = ["muscle_group_id"],
        onDelete = ForeignKey.CASCADE
    )],
)

data class ExerciseEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "exercise_id")
    val id: Long,

    @ColumnInfo(name = "exercise_name")
    val name: String,

    @ColumnInfo(name = "muscle_group_id")
    val muscleGroupId: Long,
)
