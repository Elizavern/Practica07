package com.example.practica07

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {

    val context = LocalContext.current

    var menuAbierto by remember {
        mutableStateOf(false)
    }
    var titulo by remember {
        mutableStateOf("Inicio")
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Práctica 07 - $titulo")
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            titulo = "Inicio"
                            Toast.makeText(
                                context,
                                "Pantalla de inicio",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.Home,
                            contentDescription = "Inicio"
                        )
                    }
                },

                actions = {
                    IconButton(
                        onClick = {
                            menuAbierto = true
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.MoreVert,
                            contentDescription = "Menú de opciones"
                        )
                    }

                    DropdownMenu(
                        expanded = menuAbierto,
                        onDismissRequest = {
                            menuAbierto = false
                        }
                    ) {
                        DropdownMenuItem(

                            text = { Text("Inicio") },
                            leadingIcon = {
                                Icon(
                                    Icons.Default.Home,
                                    contentDescription = null
                                )
                            },
                            onClick = {
                                titulo = "Inicio"
                                menuAbierto = false
                                Toast.makeText(
                                    context,
                                    "Seleccionaste Inicio",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        )

                        DropdownMenuItem(

                            text = { Text("Configuración") },
                            leadingIcon = {
                                Icon(
                                    Icons.Default.Settings,
                                    contentDescription = null
                                )
                            },
                            onClick = {
                                titulo = "Configuración"
                                menuAbierto = false
                                Toast.makeText(
                                    context,
                                    "Seleccionaste Configuración",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        )

                        DropdownMenuItem(

                            text = { Text("Acerca de") },
                            leadingIcon = {
                                Icon(
                                    Icons.Default.Info,
                                    contentDescription = null
                                )
                            },
                            onClick = {
                                titulo = "Acerca de"
                                menuAbierto = false
                                Toast.makeText(
                                    context,
                                    "Práctica 07: Menús y Material Design",
                                    Toast.LENGTH_SHORT

                                ).show()
                            }
                        )
                    }
                }
            )
        },

        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    Toast.makeText(
                        context,
                        "Elemento agregado",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Agregar elemento"
                )
            }
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center

        ) {

            Text(
                text = titulo,
                style = MaterialTheme.typography.headlineMedium
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Ejemplo de Toolbar, menús y componentes Material Design 3."
            )
        }
    }
}