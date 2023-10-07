package com.example.odev7project.ui.adapter

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.odev7project.data.entity.Ogrenciler
import com.example.odev7project.databinding.CardTasarimiBinding
import com.example.odev7project.databinding.FragmentOgrenciDetayBinding
import com.example.odev7project.ui.fragment.AnasayfaFragmentDirections
import com.example.odev7project.ui.viewmodel.AnasayfaViewModel
import com.example.odev7project.utils.gecis
import com.google.android.material.snackbar.Snackbar

class OgrencilerAdapter(var mContext:Context, var ogrencilerListesi:List<Ogrenciler>,var viewModel: AnasayfaViewModel)
    : RecyclerView.Adapter<OgrencilerAdapter.CardTasarimTutucu>() {

    inner class CardTasarimTutucu(var tasarim:CardTasarimiBinding) : RecyclerView.ViewHolder(tasarim.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding = CardTasarimiBinding.inflate(LayoutInflater.from(mContext), parent, false)
        return CardTasarimTutucu(binding)
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val ogrenci = ogrencilerListesi.get(position)
        val t = holder.tasarim
        t.textViewOgrenciAd.text = ogrenci.ogrenci_ad
        t.textViewOgrenciSoyad.text = ogrenci.ogrenci_soyad
        t.textViewOgrenciNo.text = ogrenci.ogrenci_no

        t.imageViewSil.setOnClickListener {
            Snackbar.make(it,"${ogrenci.ogrenci_ad} silinsin mi?",Snackbar.LENGTH_SHORT)
                .setAction("Evet"){
                    sil(ogrenci.ogrenci_id)
                }.show()
        }

        t.cardViewSatir.setOnClickListener {
            val gecis = AnasayfaFragmentDirections.ogrenciDetayGecis(ogrenci = ogrenci)
            Navigation.gecis(it,gecis)
        }
    }

    override fun getItemCount(): Int {
        return ogrencilerListesi.size
    }
    fun sil(ogrenci_id:Int){
        viewModel.sil(ogrenci_id)
    }
}