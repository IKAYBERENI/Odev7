package com.example.odev7project.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.example.odev7project.R
import com.example.odev7project.databinding.FragmentOgrenciDetayBinding
import com.example.odev7project.ui.viewmodel.AnasayfaViewModel
import com.example.odev7project.ui.viewmodel.OgrenciDetayViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OgrenciDetayFragment : Fragment() {
    private lateinit var binding: FragmentOgrenciDetayBinding
    private lateinit var viewModel: OgrenciDetayViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOgrenciDetayBinding.inflate(inflater, container, false)

        val bundle:OgrenciDetayFragmentArgs by navArgs()
        val gelenOgrenci = bundle.ogrenci
        binding.editTextOgrenciAd.setText(gelenOgrenci.ogrenci_ad)
        binding.editTextOgrenciSoyad.setText(gelenOgrenci.ogrenci_soyad)
        binding.editTextOgrenciNo.setText(gelenOgrenci.ogrenci_no)

        binding.buttonGuncelle.setOnClickListener {
            val ogrenci_ad = binding.editTextOgrenciAd.text.toString()
            val ogrenci_soyad = binding.editTextOgrenciSoyad.text.toString()
            val ogrenci_no = binding.editTextOgrenciNo.text.toString()
            guncelle(gelenOgrenci.ogrenci_id,ogrenci_ad,ogrenci_soyad,ogrenci_no)
        }

        return binding.root
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: OgrenciDetayViewModel by viewModels()
        viewModel = tempViewModel
    }
    fun guncelle(ogrenci_id:Int, ogrenci_ad:String, ogrenci_soyad:String, ogrenci_no:String){
        viewModel.guncelle(ogrenci_id,ogrenci_ad,ogrenci_soyad,ogrenci_no)
    }
}