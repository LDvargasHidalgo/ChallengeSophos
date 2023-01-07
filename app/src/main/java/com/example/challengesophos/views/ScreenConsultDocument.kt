package com.example.challengesophos.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.challengesophos.R


@Composable
fun ScreenConsultDocuments(navigationController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Encabezado()
        Spacer(modifier = Modifier.height(24.dp))
        Reporte()
    }
}

@Composable
fun Encabezado() {
    Text(text = stringResource(R.string.titulo_docs),
        style = MaterialTheme.typography.h6
    )
}

@Composable
fun Reporte() {
    Column(modifier = Modifier.fillMaxWidth()
    ) {
        Text(text = "Tabla de datos",
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        )
        Divider(Modifier.padding(horizontal = 8.dp,
            vertical = 4.dp
        ))
        Text(text = "Tabla de datos",
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        )
        Divider(Modifier.padding(horizontal = 8.dp,
            vertical = 4.dp
        ))
        Text(text = "Tabla de datos",
            Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp)
        )
    }
}


