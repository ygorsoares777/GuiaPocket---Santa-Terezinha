package com.example.guiapocket_ygor.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "comercios")
data class Comercio(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val foto: String,
    val nome: String,
    val categoria: String,
    val telefone: String,
    val endereco: String,
    val descricao: String
) : Serializable