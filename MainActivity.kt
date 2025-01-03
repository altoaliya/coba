package com.example.coba

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.coba.data.Bunga
import com.example.coba.ui.BungaViewModel
import com.example.coba.ui.Theme.BungaTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BungaTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BungaApp()
                }
            }
        }
    }
}

@Composable
fun BungaApp(viewModel: BungaViewModel = viewModel(factory = BungaViewModel.Factory)) {
    val bungaList by viewModel.allBunga.collectAsState(initial = emptyList())
    var name by remember { mutableStateOf("") }
    var price by remember { mutableStateOf("") }
    var stock by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            label = { Text("Name") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = price,
            onValueChange = { price = it },
            label = { Text("Price") },
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(
            value = stock,
            onValueChange = { stock = it },
            label = { Text("Stock") },
            modifier = Modifier.fillMaxWidth()
        )
        Button(onClick = {
            val bunga = Bunga(
                name = name,
                price = price.toDoubleOrNull() ?: 0.0,
                stock = stock.toIntOrNull() ?: 0
            )
            scope.launch {
                viewModel.insertBunga(bunga)
            }
        }, modifier = Modifier.fillMaxWidth()) {
            Text("Add Bunga")
        }

        LazyColumn(modifier = Modifier.fillMaxSize().padding(top = 16.dp)) {
            items(bungaList) { bunga ->
                Row(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
                    Text(bunga.name, modifier = Modifier.weight(1f))
                    Button(onClick = {
                        scope.launch { viewModel.deleteBunga(bunga) }
                    }) {
                        Text("Delete")
                    }
                }
            }
        }
    }
}
