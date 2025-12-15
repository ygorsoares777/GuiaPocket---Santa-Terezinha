package com.example.guiapocket_ygor.adapter

import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.guiapocket_ygor.databinding.ItemComercioBinding
import com.example.guiapocket_ygor.model.Comercio

class ComercioAdapter(
    private val comercios: List<Comercio>,
    private val onClick: (Comercio) -> Unit
) : RecyclerView.Adapter<ComercioAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemComercioBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemComercioBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val comercio = comercios[position]

        holder.binding.tvNome.text = comercio.nome
        holder.binding.tvCategoria.text = comercio.categoria

        if (comercio.foto.isNotEmpty()) {
            holder.binding.imgFoto.setImageURI(Uri.parse(comercio.foto))
        }

        holder.binding.root.setOnClickListener {
            onClick(comercio)
        }
    }

    override fun getItemCount(): Int = comercios.size
}