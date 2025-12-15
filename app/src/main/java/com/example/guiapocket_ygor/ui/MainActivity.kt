package com.example.guiapocket_ygor.ui

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.guiapocket_ygor.adapter.ComercioAdapter
import com.example.guiapocket_ygor.data.database.AppDatabase
import com.example.guiapocket_ygor.databinding.ActivityMainBinding
import com.example.guiapocket_ygor.model.Comercio
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var comercios: MutableList<Comercio>
    private lateinit var adapter: ComercioAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        comercios = mutableListOf()

        setupRecyclerView()
        loadData()
        setupListeners()
    }

    private fun loadData() {
        lifecycleScope.launch(Dispatchers.IO) {
            val db = AppDatabase.Companion.getInstance(this@MainActivity)
            val listaDoBanco = db.comercioDao().listarTodos()
            comercios = listaDoBanco.toMutableList()


            withContext(Dispatchers.Main) {
                adapter = ComercioAdapter(comercios) { comercio ->
                    val intent = Intent(this@MainActivity, DetalheActivity::class.java)
                    intent.putExtra("comercio", comercio)
                    startActivity(intent)
                }
                binding.recyclerComercios.adapter = adapter
            }
        }
    }

    private fun setupRecyclerView() {
        adapter = ComercioAdapter(emptyList()) { comercio ->
            val intent = Intent(this, DetalheActivity::class.java)
            intent.putExtra("comercio", comercio)
            startActivity(intent)
        }

        binding.recyclerComercios.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            addItemDecoration(
                DividerItemDecoration(context, DividerItemDecoration.VERTICAL)
            )
        }
    }

    //---
    private fun setupListeners() {
        binding.btnAdicionar.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }

        //textWatcher
        binding.edtFiltro.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val filtro = s.toString().lowercase()
                val filtrados = comercios.filter {
                    it.nome.lowercase().contains(filtro) ||
                            it.categoria.lowercase().contains(filtro)
                }
                adapter = ComercioAdapter(filtrados) { comercio ->
                    val intent = Intent(this@MainActivity, DetalheActivity::class.java)
                    intent.putExtra("comercio", comercio)
                    startActivity(intent)
                }
                binding.recyclerComercios.adapter = adapter
            }
            override fun afterTextChanged(s: Editable?) {}
        })
    }

    override fun onResume() {
        super.onResume()
        loadData()
    }
}