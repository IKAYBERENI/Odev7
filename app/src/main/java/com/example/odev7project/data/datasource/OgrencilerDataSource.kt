package com.example.odev7project.data.datasource

import android.util.Log
import com.example.odev7project.data.entity.Ogrenciler
import com.example.odev7project.room.OgrencilerDao
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class OgrencilerDataSource(var odao:OgrencilerDao) {
    suspend fun kaydet(ogrenci_ad: String, ogrenci_soyad: String, ogrenci_no: String) {
        val yeniOgrenci = Ogrenciler(0,ogrenci_ad,ogrenci_soyad,ogrenci_no)
        odao.kaydet(yeniOgrenci)
    }
    suspend fun guncelle(ogrenci_id:Int, ogrenci_ad:String, ogrenci_soyad:String, ogrenci_no:String){
        val guncelleOgrenci = Ogrenciler(ogrenci_id,ogrenci_ad,ogrenci_soyad,ogrenci_no)
        odao.guncelle(guncelleOgrenci)
    }

    suspend fun sil(ogrenci_id:Int){
        val silOgrenci = Ogrenciler(ogrenci_id,"","","")
        odao.sil(silOgrenci)
    }
    suspend fun ogrencilerYukle() : List<Ogrenciler> = withContext(Dispatchers.IO){

        return@withContext odao.ogrencileriYukle()
    }
    suspend fun ara(aramaKelimesi:String) : List<Ogrenciler> = withContext(Dispatchers.IO){

        return@withContext odao.ara(aramaKelimesi)
    }
}