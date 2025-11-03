package com.example.guiapocket_ygor.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.guiapocket_ygor.databinding.ItemComercioBinding
import com.example.guiapocket_ygor.model.Comercio

class ComercioAdapter (
    context: Context,
    private val lista: List<Comercio>
) : ArrayAdapter<Comercio>(context, 0, lista) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val binding: ItemComercioBinding
        val view: View

        if (convertView == null) {
            binding = ItemComercioBinding.inflate(LayoutInflater.from(context), parent, false)
            view = binding.root
            view.tag = binding
        } else {
            view = convertView
            binding = view.tag as ItemComercioBinding
        }

        val comercio = lista[position]

        binding.imgFoto.setImageResource(comercio.foto)
        binding.tvNome.text = comercio.nome
        binding.tvCategoria.text = comercio.categoria


        return view
    }
}