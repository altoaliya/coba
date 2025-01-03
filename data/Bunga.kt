package com.example.coba.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "bunga")
data class Bunga(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val name: String,
    val price: Double,
    val stock: Int
)
