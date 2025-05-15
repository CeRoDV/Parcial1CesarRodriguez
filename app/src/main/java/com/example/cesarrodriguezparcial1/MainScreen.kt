package com.example.cesarrodriguezparcial1

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
@Preview
fun App() {
    val context = LocalContext.current
    var nota by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Parcial #1", style = MaterialTheme.typography.headlineMedium)
        Spacer(modifier = Modifier.height(8.dp))
        Text("Estudiante: César Rodríguez")

        Spacer(modifier = Modifier.height(16.dp))
        Text("Ingrese la nota a validar:")
        TextField(
            value = nota,
            onValueChange = { nota = it },
            label = { Text("Nota") },
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = {
            val num = nota.toFloatOrNull()
            val mensaje = when {
                num == null -> "Ingrese una nota válida"
                num <= 100 && num >= 91 -> "Nota: A(Excelente)"
                num <= 90 && num >= 81 -> "Nota: B(Bueno)"
                num <= 80 && num >= 71 -> "Nota: C(Regular)"
                num <= 70 && num >= 61 -> "Nota: D(Más o menos regular)"
                num <= 60 && num >= 0 -> "No Aprobado, gracias por participar"
                else -> "Ingrese una nota válida"
            }
            Toast.makeText(context, mensaje, Toast.LENGTH_LONG).show()
        }) {
            Text("Validar")
        }
    }
}