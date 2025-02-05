package com.mnhyim.gymetric.di

import android.content.Context
import androidx.room.Room
import com.mnhyim.gymetric.data.GymetricDatabase
import com.mnhyim.gymetric.data.dao.ExerciseDao
import com.mnhyim.gymetric.data.dao.MuscleGroupDao
import com.mnhyim.gymetric.data.repository.ExerciseRepositoryImpl
import com.mnhyim.gymetric.data.repository.MuscleGroupRepositoryImpl
import com.mnhyim.gymetric.domain.repository.ExerciseRepository
import com.mnhyim.gymetric.domain.repository.MuscleGroupRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {

    @Provides
    @Singleton
    fun provideRoomDatabase(
        @ApplicationContext context: Context
    ): GymetricDatabase {
        return Room.databaseBuilder(
            context,
            GymetricDatabase::class.java,
            "gymetric_database"
        ).build()
    }

    @Provides
    @Singleton
    fun provideMuscleGroupDao(
        database: GymetricDatabase
    ): MuscleGroupDao {
        return database.muscleGroupDao()
    }

    @Provides
    @Singleton
    fun provideExerciseDao(
        database: GymetricDatabase
    ): ExerciseDao {
        return database.exerciseDao()
    }

    @Provides
    @Singleton
    fun provideMuscleGroupRepository(
        muscleGroupDao: MuscleGroupDao
    ): MuscleGroupRepository {
        return MuscleGroupRepositoryImpl(muscleGroupDao)
    }


    @Provides
    @Singleton
    fun provideExerciseRepository(
        muscleGroupDao: MuscleGroupDao,
        exerciseDao: ExerciseDao
    ): ExerciseRepository {
        return ExerciseRepositoryImpl(muscleGroupDao, exerciseDao)
    }
}