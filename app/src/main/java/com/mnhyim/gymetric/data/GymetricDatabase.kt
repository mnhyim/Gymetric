package com.mnhyim.gymetric.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mnhyim.gymetric.data.dao.ExerciseDao
import com.mnhyim.gymetric.data.dao.MuscleGroupDao
import com.mnhyim.gymetric.data.entity.ExerciseEntity
import com.mnhyim.gymetric.data.entity.MuscleGroupEntity
import com.mnhyim.gymetric.data.entity.MuscleGroupWithExercisesEntity

@Database(
    entities = [MuscleGroupEntity::class, ExerciseEntity::class],
    version = 1,
)
abstract class GymetricDatabase : RoomDatabase() {
    abstract fun muscleGroupDao(): MuscleGroupDao
    abstract fun exerciseDao(): ExerciseDao
}