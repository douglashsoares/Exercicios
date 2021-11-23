package com.douglas.exercicios.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PessoaEntity (

    @PrimaryKey val id: String,
    @ColumnInfo (name = "nome")  val nome: String,
    @ColumnInfo (name = "idade") val idade: Int


        )