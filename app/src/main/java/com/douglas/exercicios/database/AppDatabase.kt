package com.douglas.exercicios.database


import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.douglas.exercicios.App
import com.douglas.exercicios.models.Pessoa
import com.douglas.exercicios.models.PessoaEntity

object DatabaseUtil {

    val db = Room.databaseBuilder(
        App.instance,
        AppDatabase::class.java, "database-name"
    ).allowMainThreadQueries()
        .build()
}

@Database(entities = [PessoaEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun pessoaDao(): PessoaDao
    abstract fun animalDao(): AnimalDao
}