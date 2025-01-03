package com.example.coba.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Bunga::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun bungaDao(): BungaDao
}