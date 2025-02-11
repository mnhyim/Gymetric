package com.mnhyim.gymetric.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "training_set")
data class TrainingSetEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "training_set_id")
    val id: Long
)
