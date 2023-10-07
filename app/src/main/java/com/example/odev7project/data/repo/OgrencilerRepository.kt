package com.example.odev7project.data.repo

import android.util.Log
import com.example.odev7project.data.datasource.OgrencilerDataSource
import com.example.odev7project.data.entity.Ogrenciler

class OgrencilerRepository(var ods:OgrencilerDataSource) {
    suspend fun kaydet(ogrenci_ad: String, ogrenci_soyad: String, ogrenci_no: String) = ods.kaydet(ogrenci_ad,ogrenci_soyad,ogrenci_no)

    suspend fun guncelle(ogrenci_id:Int, ogrenci_ad:String, ogrenci_soyad:String, ogrenci_no:String) = ods.guncelle(ogrenci_id,ogrenci_ad,ogrenci_soyad,ogrenci_no)

    suspend fun sil(ogrenci_id:Int) = ods.sil(ogrenci_id)

    suspend fun ogrencilerYukle() : List<Ogrenciler> = ods.ogrencilerYukle()

    suspend fun ara(aramaKelimesi:String) : List<Ogrenciler> = ods.ara(aramaKelimesi)
}
