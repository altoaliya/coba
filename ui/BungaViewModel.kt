package com.example.coba.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.CreationExtras
import com.example.coba.data.Bunga
import com.example.coba.data.BungaRepository
import com.example.coba.TokoBunga
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

class BungaViewModel(private val repository: BungaRepository) : ViewModel() {
    val allBunga: Flow<List<Bunga>> = repository.getAllBunga()

    fun insertBunga(bunga: Bunga) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertBunga(bunga)
        }
    }

    fun updateBunga(bunga: Bunga) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateBunga(bunga)
        }
    }

    fun deleteBunga(bunga: Bunga) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteBunga(bunga)
        }
    }

    suspend fun getBungaById(id: Int): Bunga? {
        return repository.getBungaById(id)
    }

    companion object {
        val Factory: ViewModelProvider.Factory = object : ViewModelProvider.Factory {
            @Suppress("UNCHECKED_CAST")
            override fun <T : ViewModel> create(
                modelClass: Class<T>,
                extras: CreationExtras
            ): T {
                val application =
                    checkNotNull(extras[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY])
                return BungaViewModel(
                    (application as TokoBunga).repository
                ) as T
            }
        }
    }
}
