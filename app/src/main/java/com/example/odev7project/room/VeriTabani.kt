package com.example.odev7project.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.odev7project.data.entity.Ogrenciler

@Database(entities = [Ogrenciler::class], version = 1)
abstract class VeriTabani : RoomDatabase() {
    abstract fun  getOgrencilerDao() : OgrencilerDao
}