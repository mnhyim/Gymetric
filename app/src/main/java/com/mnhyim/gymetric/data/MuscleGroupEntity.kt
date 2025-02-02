package com.mnhyim.gymetric.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MuscleGroupEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "") val id: Long,
    @ColumnInfo(name = "") val name: String
)