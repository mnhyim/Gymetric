package com.mnhyim.gymetric.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mnhyim.gymetric.data.dao.MuscleGroupDao
import com.mnhyim.gymetric.data.entity.MuscleGroupEntity

@Database(
    entities = [MuscleGroupEntity::class],
    version = 1,
)
abstract class GymetricDatabase : RoomDatabase() {
    abstract fun muscleGroupDao(): MuscleGroupDao
}