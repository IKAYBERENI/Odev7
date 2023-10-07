package com.example.odev7project.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import com.example.odev7project.data.repo.OgrencilerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel

class OgrenciKayitViewModel @Inject constructor(var orepo:OgrencilerRepository) : ViewModel() {
    fun kaydet(ogrenci_ad: String, ogrenci_soyad: String, ogrenci_no: String) {
        CoroutineScope(Dispatchers.Main).launch {
            orepo.kaydet(ogrenci_ad,ogrenci_soyad,ogrenci_no)
        }
    }
}