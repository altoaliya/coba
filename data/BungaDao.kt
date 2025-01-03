package com.example.coba.data

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface BungaDao {
    @Insert
    suspend fun insert(bunga: Bunga)

    @Update
    suspend fun update(bunga: Bunga)

    @Delete
    suspend fun delete(bunga: Bunga)

    @Query("SELECT * FROM bunga")
    fun getAllFlowers(): Flow<List<Bunga>>

    @Query("SELECT * FROM bunga WHERE id = :id")
    suspend fun getBungaById(id: Int): Bunga?
}