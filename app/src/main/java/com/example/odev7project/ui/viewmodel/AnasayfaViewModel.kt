package com.example.odev7project.ui.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.odev7project.data.entity.Ogrenciler
import com.example.odev7project.data.repo.OgrencilerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel

class AnasayfaViewModel @Inject constructor(var orepo:OgrencilerRepository): ViewModel() {
    var ogrencilerListesi = MutableLiveData<List<Ogrenciler>>()

    init {
        ogrencilerYukle()
    }

    fun sil(ogrenci_id:Int){
        CoroutineScope(Dispatchers.Main).launch {
            orepo.sil(ogrenci_id)
            ogrencilerYukle()
        }
    }
    fun ogrencilerYukle(){
        CoroutineScope(Dispatchers.Main).launch {
            ogrencilerListesi.value = orepo.ogrencilerYukle()
        }
    }
    fun ara(aramaKelimesi:String){
        CoroutineScope(Dispatchers.Main).launch {
            ogrencilerListesi.value = orepo.ara(aramaKelimesi)
        }
    }
}