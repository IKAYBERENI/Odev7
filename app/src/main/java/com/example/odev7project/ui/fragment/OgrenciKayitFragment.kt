package com.example.odev7project.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.odev7project.R
import com.example.odev7project.databinding.FragmentOgrenciKayitBinding
import com.example.odev7project.ui.viewmodel.AnasayfaViewModel
import com.example.odev7project.ui.viewmodel.OgrenciKayitViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OgrenciKayitFragment : Fragment() {
    private lateinit var binding: FragmentOgrenciKayitBinding
    private lateinit var viewModel: OgrenciKayitViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOgrenciKayitBinding.inflate(inflater, container, false)

        binding.buttonKaydet.setOnClickListener {
            val ogrenci_ad = binding.editTextOgrenciAd.text.toString()
            val ogrenci_soyad = binding.editTextOgrenciSoyad.text.toString()
            val ogrenci_no = binding.editTextOgrenciNo.text.toString()
            kaydet(ogrenci_ad,ogrenci_soyad,ogrenci_no)
        }

        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: OgrenciKayitViewModel by viewModels()
        viewModel = tempViewModel
    }

    fun kaydet(ogrenci_ad:String, ogrenci_soyad:String, ogrenci_no:String){
        viewModel.kaydet(ogrenci_ad,ogrenci_soyad,ogrenci_no)
    }
}