package com.example.odev7project.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.odev7project.data.entity.Ogrenciler

@Dao
interface OgrencilerDao {
    @Query("SELECT * FROM ogrenciler")
    suspend fun ogrencileriYukle() : List<Ogrenciler>

    @Insert
    suspend fun kaydet(ogrenci:Ogrenciler)

    @Update
    suspend fun guncelle(ogrenci:Ogrenciler)

    @Delete
    suspend fun sil(ogrenci: Ogrenciler)

    @Query("SELECT * FROM ogrenciler WHERE ogrenci_ad like '%'||:aramaKelimesi|| '%'")
    suspend fun ara(aramaKelimesi:String) : List<Ogrenciler>
}