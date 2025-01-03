package com.example.coba.data

import kotlinx.coroutines.flow.Flow

class BungaRepository(private val bungaDao: BungaDao) {
    fun getAllBunga(): Flow<List<Bunga>> = bungaDao.getAllFlowers()
    suspend fun insertBunga(bunga: Bunga) = bungaDao.insert(bunga)
    suspend fun updateBunga(bunga: Bunga) = bungaDao.update(bunga)
    suspend fun deleteBunga(bunga: Bunga) = bungaDao.delete(bunga)
    suspend fun getBungaById(id: Int): Bunga? = bungaDao.getBungaById(id)
}