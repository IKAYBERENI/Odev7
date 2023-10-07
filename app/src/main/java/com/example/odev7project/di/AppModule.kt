package com.example.odev7project.di

import android.content.Context
import androidx.room.Room
import com.example.odev7project.data.datasource.OgrencilerDataSource
import com.example.odev7project.data.repo.OgrencilerRepository
import com.example.odev7project.room.OgrencilerDao
import com.example.odev7project.room.VeriTabani
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideOgrencilerRepository(ods:OgrencilerDataSource) : OgrencilerRepository {
        return OgrencilerRepository(ods)
    }
    @Provides
    @Singleton
    fun provideOgrencilerDataSource(odao:OgrencilerDao) : OgrencilerDataSource {
        return OgrencilerDataSource(odao)
    }
    @Provides
    @Singleton
    fun provideOgrencilerDao(@ApplicationContext context:Context) : OgrencilerDao {
        val vt = Room.databaseBuilder(context,VeriTabani::class.java,"odev7.sqlite.")
            .createFromAsset("odev7.sqlite").build()
        return vt.getOgrencilerDao()
    }
}