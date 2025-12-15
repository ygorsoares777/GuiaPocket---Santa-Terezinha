package com.example.guiapocket_ygor.ui

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.guiapocket_ygor.R
import com.example.guiapocket_ygor.data.database.AppDatabase
import com.example.guiapocket_ygor.databinding.ActivityCadastroBinding
import com.example.guiapocket_ygor.model.Comercio
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext



class CadastroActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCadastroBinding
    private lateinit var launcherGaleria: ActivityResultLauncher<Array<String>>
    private var uriSelecionada: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCadastroBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupLauncher()
        setupListeners()
    }

    private fun setupLauncher() {
        launcherGaleria = registerForActivityResult(
            ActivityResultContracts.OpenDocument()
        ) { uri ->
            if (uri != null) {
                contentResolver.takePersistableUriPermission(
                    uri,
                    Intent.FLAG_GRANT_READ_URI_PERMISSION
                )
                uriSelecionada = uri.toString()
                binding.imgFoto.setImageURI(uri)
            }
        }
    }

    private fun setupListeners() {
        binding.imgFoto.setOnClickListener {
            launcherGaleria.launch(arrayOf("image/*"))
        }

        binding.btnSalvar.setOnClickListener {
            val nome = binding.edtNome.text.toString()
            val categoria = binding.edtCategoria.text.toString()
            val telefone = binding.edtTelefone.text.toString()
            val endereco = binding.edtEndereco.text.toString()
            val descricao = binding.edtDescricao.text.toString()

            if (nome.isNotBlank() && categoria.isNotBlank()) {
                val novoComercio = Comercio(
                    foto = uriSelecionada,
                    nome = nome,
                    categoria = categoria,
                    telefone = telefone,
                    endereco = endereco,
                    descricao = descricao
                )

                salvarNoBanco(novoComercio)
            } else {
                Toast.makeText(this, getString(R.string.fill_required_fields), Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnVoltar.setOnClickListener {
            finish()
        }
    }

    private fun salvarNoBanco(comercio: Comercio) {
        lifecycleScope.launch(Dispatchers.IO) {
            val db = AppDatabase.Companion.getInstance(this@CadastroActivity)
            db.comercioDao().inserir(comercio)

            withContext(Dispatchers.Main) {
                Toast.makeText(
                    this@CadastroActivity,
                    getString(R.string.saved_successfully),
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            }
        }
    }
}