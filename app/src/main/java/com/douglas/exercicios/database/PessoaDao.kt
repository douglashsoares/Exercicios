package com.douglas.exercicios.database

import androidx.room.*
import com.douglas.exercicios.models.PessoaEntity

@Dao
interface PessoaDao {

    @Query("SELECT * FROM PessoaEntity")
    fun getAll(): List<PessoaEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(pessoa: PessoaEntity)

    @Update
    fun update(pessoa: PessoaEntity)

    @Query("DELETE FROM pessoaEntity WHERE id = :pessoaId")
    fun delete(pessoaId: String)

}