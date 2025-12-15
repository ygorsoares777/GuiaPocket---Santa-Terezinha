package com.example.guiapocket_ygor.data.dao

import androidx.room.*
import androidx.room.Dao
import com.example.guiapocket_ygor.model.Comercio

@Dao
interface ComercioDao {

    @Insert
    suspend fun inserir(comercio: Comercio)

    @Query("SELECT * FROM comercios ORDER BY nome ASC")
    suspend fun listarTodos(): List<Comercio>

    @Query("SELECT * FROM comercios WHERE nome LIKE '%' || :filtro || '%' ORDER BY nome ASC")
    suspend fun filtrarPorNome(filtro: String): List<Comercio>

    @Query("SELECT * FROM comercios WHERE id = :id")
    suspend fun buscarPorId(id: Int): Comercio?

    @Update
    suspend fun atualizar(comercio: Comercio)

    @Delete
    suspend fun deletar(comercio: Comercio)
}