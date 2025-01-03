package com.example.coba

import android.app.Application
import androidx.room.Room
import com.example.coba.data.AppDatabase
import com.example.coba.data.BungaRepository

class TokoBunga : Application() {
    lateinit var repository: BungaRepository

    override fun onCreate() {
        super.onCreate()
        val database = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java,
            "bunga_database"
        ).build()
        repository = BungaRepository(database.bungaDao())
    }
}