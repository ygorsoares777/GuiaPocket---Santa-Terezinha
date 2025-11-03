package com.example.guiapocket_ygor.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.guiapocket_ygor.R
import com.example.guiapocket_ygor.databinding.ActivityDetalheBinding

class DetalheActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetalheBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetalheBinding.inflate(layoutInflater)
        setContentView(binding.root)

        exibirInformacoes()
        configurarBotoes()
    }

    private fun exibirInformacoes() {
        val nome = intent.getStringExtra("NOME_COMERCIO")
        val categoria = intent.getStringExtra("CATEGORIA_COMERCIO")
        val descricao = intent.getStringExtra("DESCRICAO_COMERCIO")
        val telefone = intent.getStringExtra("TELEFONE_COMERCIO")
        val endereco = intent.getStringExtra("ENDERECO_COMERCIO")
        val imagem = intent.getIntExtra("IMAGEM_COMERCIO", R.drawable.ic_launcher_foreground)

        // Definir todas as informações nos TextViews
        binding.tvNome.text = nome ?: getString(R.string.service_image)
        binding.tvCategoria.text = categoria ?: getString(R.string.service_image)
        binding.tvDescricao.text = descricao ?: getString(R.string.service_image)
        binding.imgFoto.setImageResource(imagem)

        // Guardar telefone e endereço nos botões para usar nos listeners
        binding.btnLigar.tag = telefone
        binding.btnEndereco.tag = endereco
    }

    private fun configurarBotoes() {
        // Botão Ligar - Intent implícita para discador
        binding.btnLigar.setOnClickListener {
            val telefone = it.tag as? String
            if (!telefone.isNullOrEmpty()) {
                val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$telefone"))
                startActivity(intent)
            } else {
                Toast.makeText(this, getString(R.string.service_image), Toast.LENGTH_SHORT).show()
            }
        }

        // Botão Ver Endereço - Intent implícita para Google Maps
        binding.btnEndereco.setOnClickListener {
            val endereco = it.tag as? String
            if (!endereco.isNullOrEmpty()) {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse("geo:0,0?q=${Uri.encode(endereco)}"))
                startActivity(intent)
            } else {
                Toast.makeText(this, getString(R.string.service_image), Toast.LENGTH_SHORT).show()
            }
        }

        // Botão Voltar - Finaliza a Activity atual
        binding.btnVoltar.setOnClickListener {
            finish()
        }
    }
}