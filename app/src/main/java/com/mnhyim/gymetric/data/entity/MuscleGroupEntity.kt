package com.mnhyim.gymetric.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "muscle_group")
data class MuscleGroupEntity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "muscle_group_id") val id: Long,
    @ColumnInfo(name = "muscle_group_name") val name: String
)