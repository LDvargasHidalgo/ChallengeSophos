package com.example.challengesophos.views

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.challengesophos.R


@Composable
fun ScreenConsultDocuments(navigationController: NavHostController) {
    Scaffold() {
        ToolbarConsultDocument(navigationController)
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(Modifier.height(42.dp))
            Encabezado()
            Spacer(modifier = Modifier.height(24.dp))
            Reporte()
        }
    }
    }


@Composable
fun ToolbarConsultDocument(navController: NavHostController) {
    TopAppBar(
        title = {
            Text(
                text = "Regresar",
                color = colorResource(id = R.color.purple),
                fontWeight = FontWeight.W600,
                modifier = Modifier
                    .padding(horizontal = 12.dp)
            )
        },
        navigationIcon = {
            IconButton(onClick = { navController.navigate("screenMain/Laura Daniela")}) {
                Icon(
                    modifier = Modifier.size(32.dp),
                    imageVector = Icons.Outlined.ArrowBack,
                    contentDescription = null,
                    tint = colorResource(id = R.color.purple),

                    )
            }
        },
        backgroundColor = Color(0xFFFEFEFE)

    )
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


