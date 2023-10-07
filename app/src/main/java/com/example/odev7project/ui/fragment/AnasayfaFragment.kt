package com.example.odev7project.ui.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.SearchView
import androidx.appcompat.widget.SearchView.OnQueryTextListener
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.odev7project.R
import com.example.odev7project.data.entity.Ogrenciler
import com.example.odev7project.databinding.FragmentAnasayfaBinding
import com.example.odev7project.ui.adapter.OgrencilerAdapter
import com.example.odev7project.ui.viewmodel.AnasayfaViewModel
import com.example.odev7project.utils.gecis
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AnasayfaFragment : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    private lateinit var viewModel: AnasayfaViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAnasayfaBinding.inflate(inflater, container, false)

        binding.rv.layoutManager = LinearLayoutManager(requireContext())

        viewModel.ogrencilerListesi.observe(viewLifecycleOwner){
            val ogrencilerAdapter = OgrencilerAdapter(requireContext(),it,viewModel)
            binding.rv.adapter = ogrencilerAdapter
        }

        binding.fab.setOnClickListener{
            Navigation.gecis(it,R.id.ogrenciKayitGecis)
        }

        binding.searchView.setOnQueryTextListener(object : android.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextChange(newText: String): Boolean {
                ara(newText)
                return true
            }

            override fun onQueryTextSubmit(query: String): Boolean {
                ara(query)
                return false
            }
        })
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val tempViewModel: AnasayfaViewModel by viewModels()
        viewModel = tempViewModel
    }
    fun ara(aramaKelimesi:String){
        viewModel.ara(aramaKelimesi)
    }
    override fun onResume() {
        super.onResume()
        viewModel.ogrencilerYukle()
    }
}