package com.douglas.exercicios.models

data class Pessoa(
    val id: String,
    var nome: String,
    var idade: Int
){

    fun ehMaiorDeIdade(): Boolean{
        return idade >= 18
    }
}

