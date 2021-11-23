package com.douglas.exercicios.modelsAnimais

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class AnimaisEntity(

    @PrimaryKey val id: Int,
    @ColumnInfo (name = "Nome") val nome: String,
    @ColumnInfo(name = "Raça") val raca: String,
    @ColumnInfo (name = "Tipo") val tipo:String

)



