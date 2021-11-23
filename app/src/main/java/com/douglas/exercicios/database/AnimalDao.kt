package com.douglas.exercicios.database

import androidx.room.Dao
import androidx.room.Query
import com.douglas.exercicios.modelsAnimais.AnimaisEntity

@Dao
interface AnimalDao {

    @Query ("SELECT * FROM AnimaisEntity")
    fun getAll(): List<AnimaisEntity>


}