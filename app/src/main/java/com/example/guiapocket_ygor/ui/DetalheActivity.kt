package com.example.guiapocket_ygor.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.net.toUri
import com.example.guiapocket_ygor.R
import com.example.guiapocket_ygor.databinding.ActivityDetalheBinding
import com.example.guiapocket_ygor.model.Comercio

class DetalheActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalheBinding
    private lateinit var comercio: Comercio

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalheBinding.inflate(layoutInflater)
        setContentView(binding.root)

        comercio = intent.getSerializableExtra("comercio", Comercio::class.java) ?: run {
            Toast.makeText(this, getString(R.string.business_not_found), Toast.LENGTH_SHORT).show()
            finish()
            return
        }

        setupViews()
        setupListeners()
    }

    private fun setupViews() {
        binding.tvNome.text = comercio.nome
        binding.tvCategoria.text = comercio.categoria
        binding.tvDescricao.text = comercio.descricao

        if (comercio.foto.isNotEmpty()) {
            binding.imgFoto.setImageURI(comercio.foto.toUri())
        }

        binding.btnLigar.tag = comercio.telefone
        binding.btnEndereco.tag = comercio.endereco
    }

    private fun setupListeners() {
        binding.btnLigar.setOnClickListener {
            val telefone = it.tag as? String
            if (!telefone.isNullOrEmpty()) {
                startActivity(Intent(Intent.ACTION_DIAL, "tel:$telefone".toUri()))
            } else {
                Toast.makeText(this, getString(R.string.phone_not_available), Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnEndereco.setOnClickListener {
            val endereco = it.tag as? String
            if (!endereco.isNullOrEmpty()) {
                startActivity(
                    Intent(
                        Intent.ACTION_VIEW,
                        "geo:0,0?q=${Uri.encode(endereco)}".toUri()
                    )
                )
            } else {
                Toast.makeText(this, getString(R.string.address_not_available), Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnVoltar.setOnClickListener {
            finish()
        }
    }
}