package com.example.guiapocket_ygor.ui


import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import androidx.appcompat.app.AppCompatActivity
import com.example.guiapocket_ygor.R
import com.example.guiapocket_ygor.adapter.ComercioAdapter
import com.example.guiapocket_ygor.databinding.ActivityMainBinding
import com.example.guiapocket_ygor.model.Comercio

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: ComercioAdapter
    private lateinit var listaComercios: List<Comercio>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        configurarLista()
        configurarClique()
    }

    private fun configurarLista() {
        listaComercios = listOf(
            Comercio(
                id = 1,
                foto = R.drawable.kobauto,
                nome = getString(R.string.kobauto_nome),
                categoria = getString(R.string.kobauto_categoria),
                descricao = getString(R.string.kobauto_descricao),
                telefone = "(16) 99742-3643",
                endereco = getString(R.string.kobauto_endereco)
            ),
            Comercio(
                id = 2,
                foto = R.drawable.sempreon,
                nome = getString(R.string.sempreon_nome),
                categoria = getString(R.string.sempreon_categoria),
                descricao = getString(R.string.sempreon_descricao),
                telefone = "(16) 99744-8327",
                endereco = getString(R.string.sempreon_endereco)
            ),
            Comercio(
                id = 3,
                foto = R.drawable.quintal,
                nome = getString(R.string.quintal_acai_nome),
                categoria = getString(R.string.quintal_acai_categoria),
                descricao = getString(R.string.quintal_acai_descricao),
                telefone = "(16) 99731-7051",
                endereco = getString(R.string.quintal_acai_endereco)
            ),
            Comercio(
                id = 4,
                foto = R.drawable.amaluca,
                nome = getString(R.string.amaluca_nome),
                categoria = getString(R.string.amaluca_categoria),
                descricao = getString(R.string.amaluca_descricao),
                telefone = "(16) 3392-6888",
                endereco = getString(R.string.amaluca_endereco)
            ),
            Comercio(
                id = 5,
                foto = R.drawable.alves,
                nome = getString(R.string.alves_mercado_nome),
                categoria = getString(R.string.alves_mercado_categoria),
                descricao = getString(R.string.alves_mercado_descricao),
                telefone = "(16) 3392-7510",
                endereco = getString(R.string.alves_mercado_endereco)
            ),
            Comercio(
                id = 6,
                foto = R.drawable.pontodochurrasco,
                nome = getString(R.string.ponto_churrasco_nome),
                categoria = getString(R.string.ponto_churrasco_categoria),
                descricao = getString(R.string.ponto_churrasco_descricao),
                telefone = "(16) 3392-2665",
                endereco = getString(R.string.ponto_churrasco_endereco)
            )
        )

        adapter = ComercioAdapter(this, listaComercios)
        binding.listViewComercios.adapter = adapter
    }

    private fun configurarClique() {
        binding.listViewComercios.onItemClickListener =
            AdapterView.OnItemClickListener { _, _, position, _ ->
                val comercio = listaComercios[position]

                val intent = Intent(this, DetalheActivity::class.java).apply {
                    putExtra("NOME_COMERCIO", comercio.nome)
                    putExtra("CATEGORIA_COMERCIO", comercio.categoria)
                    putExtra("DESCRICAO_COMERCIO", comercio.descricao)
                    putExtra("TELEFONE_COMERCIO", comercio.telefone)
                    putExtra("ENDERECO_COMERCIO", comercio.endereco)
                    putExtra("IMAGEM_COMERCIO", comercio.foto)
                }
                startActivity(intent)
            }
    }
}