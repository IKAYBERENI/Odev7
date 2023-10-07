package com.example.odev7project.data.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.jetbrains.annotations.NotNull
import java.io.Serializable

@Entity(tableName = "ogrenciler")
data class Ogrenciler(@PrimaryKey(autoGenerate = true)
                      @ColumnInfo(name = "ogrenci_id") @NotNull var ogrenci_id:Int,
                      @ColumnInfo(name = "ogrenci_ad") @NotNull var ogrenci_ad:String,
                      @ColumnInfo(name = "ogrenci_soyad") @NotNull var ogrenci_soyad:String,
                      @ColumnInfo(name = "ogrenci_no") @NotNull var ogrenci_no:String) : Serializable{
}