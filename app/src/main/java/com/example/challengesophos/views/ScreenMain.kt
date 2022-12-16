package com.example.challengesophos.views


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Description
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.FindInPage
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.challengesophos.R


@Composable
fun ScreenMain() {
    Column(
        Modifier
            .fillMaxSize()
            .fillMaxWidth()
    ) {
        TopImage()
        SendDocuments()
        ShowDocuments()
        Ofice()
    }

}

@Composable
fun TopImage() {
    Image(
        painter = painterResource(id = R.drawable.plantilla_corporativa_2022_1),
        contentDescription = "welcome Image",
        modifier = Modifier.size(400.dp)
    )
}

@Composable
fun SendDocuments() {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {
        Row(Modifier.fillMaxWidth()) {
            Icon(
                imageVector = Icons.Default.Description,
                contentDescription = null
            )
            Text(text = "Enviar Documentos")
        }
        OutlinedButton(
            onClick = { /*TODO*/ },
            Modifier.align(Alignment.End),
            border = BorderStroke(2.dp, color = Color(0xFF7800FD)),
            shape = MaterialTheme.shapes.large
        ) {
            Spacer(modifier = Modifier.width(12.dp))

            Text(text = "Ingresar")
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = null
            )

        }
    }
}

@Composable
fun Ofice() {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {
        Row(Modifier.fillMaxWidth()) {
            Icon(
                imageVector = Icons.Default.LocationOn,
                contentDescription = null
            )
            Text(text = "Oficinas")
        }
        OutlinedButton(
            onClick = { /*TODO*/ },
            Modifier.align(Alignment.End),
            border = BorderStroke(2.dp, color = Color(0xFF7800FD)),
            shape = MaterialTheme.shapes.large
        ) {
            Spacer(modifier = Modifier.width(12.dp))

            Text(text = "Ingresar")
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = null
            )

        }
    }
}

@Composable
fun ShowDocuments() {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(24.dp)
    ) {
        Row(Modifier.fillMaxWidth()) {
            Icon(
                imageVector = Icons.Default.FindInPage,
                contentDescription = null
            )
            Text(text = "Ver documentos")
        }
        OutlinedButton(
            onClick = { /*TODO*/ },
            Modifier.align(Alignment.End),
            border = BorderStroke(2.dp, color = Color(0xFF7800FD)),
            shape = MaterialTheme.shapes.large
        ) {
            Spacer(modifier = Modifier.width(12.dp))

            Text(text = "Ingresar")
            Icon(
                imageVector = Icons.Default.ArrowForward,
                contentDescription = null
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun MainPreview() {
    ScreenMain()
}

