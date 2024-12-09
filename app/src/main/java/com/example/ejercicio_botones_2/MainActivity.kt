package com.example.ejercicio_botones_2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ejercicio_botones_2.ui.theme.Ejercicio_Botones_2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejercicio_Botones_2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    MyScreen()
}
@Composable
fun MyScreen() {
    var mainText by remember { mutableStateOf("Texto inicial") }

    val showConfirmationDialog = remember { mutableStateOf(false) }
    val showDeletionDialog = remember { mutableStateOf(false) }
    val showInformationDialog = remember { mutableStateOf(false) }
    val showAuthenticationDialog = remember { mutableStateOf(false) }
    val showErrorDialog = remember { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = mainText, fontSize = 20.sp)
        Spacer(modifier = Modifier.height(16.dp))

        Button(onClick = { showConfirmationDialog.value = true }) {
            Text("Confirmación de Acción")
        }
        Button(onClick = { showDeletionDialog.value = true }) {
            Text("Eliminar Elemento")
        }
        Button(onClick = { showInformationDialog.value = true }) {
            Text("Información Importante")
        }
        Button(onClick = { showAuthenticationDialog.value = true }) {
            Text("Requiere Autenticación")
        }
        Button(onClick = { showErrorDialog.value = true }) {
            Text("Error Crítico")
        }
    }


    if (showConfirmationDialog.value) {
        AlertDialog(
            onDismissRequest = { showConfirmationDialog.value = false },
            title = { Text("Confirmación de Acción") },
            text = { Text("¿Estás seguro de que deseas continuar con esta acción?") },
            confirmButton = {
                Button(onClick = {
                    showConfirmationDialog.value = false
                    mainText = "Acción Confirmada"
                }) {
                    Text("Sí")
                }
            },
            dismissButton = {
                Button(onClick = { showConfirmationDialog.value = false }) {
                    Text("No")
                }
            }
        )
    }

    if (showDeletionDialog.value) {
        AlertDialog(
            onDismissRequest = { showDeletionDialog.value = false },
            title = { Text("Eliminar Elemento") },
            text = { Text("Esta acción es irreversible. ¿Deseas eliminar este elemento?") },
            confirmButton = {
                Button(onClick = {
                    showDeletionDialog.value = false
                    mainText = "Elemento Eliminado"
                }) {
                    Text("Eliminar")
                }
            },
            dismissButton = {
                Button(onClick = { showDeletionDialog.value = false }) {
                    Text("Cancelar")
                }
            }
        )
    }

    if (showInformationDialog.value) {
        AlertDialog(
            onDismissRequest = { showInformationDialog.value = false },
            title = { Text("Aviso Importante") },
            text = { Text("Recuerda que los cambios realizados no se pueden deshacer.") },
            confirmButton = {
                Button(onClick = { showInformationDialog.value = false }) {
                    Text("Entendido")
                }
            }
        )
    }

    if (showAuthenticationDialog.value) {
        AlertDialog(
            onDismissRequest = { showAuthenticationDialog.value = false },
            title = { Text("Requiere Autenticación") },
            text = { Text("Para continuar, necesitas autenticarte de nuevo.") },
            confirmButton = {
                Button(onClick = {
                    showAuthenticationDialog.value = false
                    mainText = "Usuario Autenticado"
                }) {
                    Text("Autenticar")
                }
            },
            dismissButton = {
                Button(onClick = { showAuthenticationDialog.value = false }) {
                    Text("Cancelar")
                }
            }
        )
    }

    if (showErrorDialog.value) {
        AlertDialog(
            onDismissRequest = { showErrorDialog.value = false },
            title = { Text("Error Crítico") },
            text = { Text("Se ha producido un error crítico. ¿Deseas intentar nuevamente?") },
            confirmButton = {
                Button(onClick = {
                    showErrorDialog.value = false
                    mainText = "Intento de Reintento"
                }) {
                    Text("Reintentar")
                }
            },
            dismissButton = {
                Button(onClick = { showErrorDialog.value = false }) {
                    Text("Cancelar")
                }
            }
        )
    }
}
@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Ejercicio_Botones_2Theme {
        Greeting("Android")
    }
}