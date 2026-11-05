package com.example.proyectoandroid

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.ui.Modifier
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.proyectoandroid.ui.theme.ProyectoAndroidTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ProyectoAndroidTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ListaRecordatorios(recordatorios, Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun ListaRecordatorios(lista: List<Recordatorio>, modifier: Modifier = Modifier) {
    LazyColumn(
        modifier = modifier.padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        item { Text("Mis recordatorios", style = MaterialTheme.typography.headlineMedium) }
        items(lista) { ItemRecordatorio(it) }
    }
}

@Composable
fun ItemRecordatorio(r: Recordatorio) {
    val color = coloresCategoria[r.categoria] ?: Color.Gray
    Card(
        modifier = Modifier.fillMaxWidth(),
        colors = CardDefaults.cardColors(containerColor = color.copy(alpha = 0.4f))
    ) {
        Column(Modifier.padding(16.dp)) {
            Text(r.titulo, style = MaterialTheme.typography.titleMedium)
            r.descripcion?.let { Text(it) }
            Text("Categoría: ${r.categoria.nombre}")
            Text("Prioridad: ${r.prioridad.nombre}")
            Text("Estado: ${r.estado.nombre}")
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ListaPreview() {
    ProyectoAndroidTheme { ListaRecordatorios(recordatorios) }
}