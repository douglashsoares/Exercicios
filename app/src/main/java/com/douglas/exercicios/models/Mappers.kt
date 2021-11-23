package com.douglas.exercicios.models

fun Pessoa.toEntity(): PessoaEntity {
    return PessoaEntity(
        id = id,
        nome = nome,
        idade = idade
    )
}

fun PessoaEntity.toUi(): Pessoa {
    return Pessoa(
        id = id,
        nome = nome,
        idade = idade
    )
}