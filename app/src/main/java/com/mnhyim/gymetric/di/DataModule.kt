package com.mnhyim.gymetric.di

import android.content.Context
import androidx.room.Room
import com.mnhyim.gymetric.data.GymetricDatabase
import com.mnhyim.gymetric.data.dao.MuscleGroupDao
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
}