package com.example.challengesophos.views



import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.AddAPhoto
import androidx.compose.material.icons.outlined.Backup
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.challengesophos.R
import com.example.challengesophos.ui.theme.Shapes
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource


@Composable
fun ScreenSendDocuments() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        HeadBoard()
        TypeDocument()
        DocumentNumber()
        PersonalInformation()
        City()
        BottomBottons()

    }

}


@Composable
fun HeadBoard() {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.align(Alignment.Start),
            text = stringResource(id = R.string.send_documents),
            fontSize = 24.sp,
            fontWeight = FontWeight.W600

        )
        Spacer(Modifier.height(12.dp))
        Icon(
            imageVector = Icons.Outlined.AddAPhoto,
            contentDescription = null,
            Modifier.size(60.dp),
            tint = Color.Black
        )
    }
}

@Composable
fun TypeDocument() {
    var expanded by remember { mutableStateOf(false) }
    val suggestions = listOf("Tipo 1", "Tipo 2", "Tipo 3")
    var selectedText by remember { mutableStateOf("") }
    var dropDownWidth by remember { mutableStateOf(0) }

    val icon = if (expanded) Icons.Filled.ArrowDropUp
    else Icons.Filled.ArrowDropDown

    Column(Modifier.padding(16.dp)) {
        OutlinedTextField(value = selectedText,
            onValueChange = { selectedText = it },
            modifier = Modifier
                .fillMaxWidth()
                .onSizeChanged {
                    dropDownWidth = it.width
                },
            label = { Text(text = stringResource(id = R.string.document_type)) },
            trailingIcon = {
                Icon(icon, "contentDescription", Modifier.clickable { expanded = !expanded })
            })
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.width(with(LocalDensity.current) { dropDownWidth.toDp() })
        ) {
            suggestions.forEach { label ->
                DropdownMenuItem(onClick = {
                    selectedText = label
                }) {
                    Text(text = label)
                }
            }
        }
    }
}

@Composable
fun DocumentNumber() {
    val selectedText by remember { mutableStateOf("") }

    Column(Modifier.padding(horizontal = 16.dp, vertical = 4.dp)) {
        TextField(
            value = selectedText,
            onValueChange = { },
            leadingIcon = {
                Icon(
                    imageVector = Icons.Default.Badge, contentDescription = null
                )
            },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(text = stringResource(id = R.string.document_number)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            singleLine = true,
            maxLines = 1,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
            )
        )
    }
}


@Composable
fun PersonalInformation() {
    Column(Modifier.padding(horizontal = 16.dp, vertical = 4.dp)) {
        TextField(
            value = "",
            onValueChange = { },
            modifier = Modifier.fillMaxWidth(),
            placeholder = { Text(stringResource(id = R.string.names)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            singleLine = true,
            maxLines = 1,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
            )
        )
        TextField(
            value = "",
            onValueChange = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            placeholder = { Text(stringResource(id = R.string.last_name)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            singleLine = true,
            maxLines = 1,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
            )
        )
        TextField(
            value = "",
            onValueChange = { },
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            placeholder = { Text(text = stringResource(id = R.string.email)) },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
            singleLine = true,
            maxLines = 1,
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = Color.White,
            )
        )
    }
}


@Composable
fun City() {
    var expanded by remember { mutableStateOf(false) }
    val suggestions = listOf("Ciudad 1", "Ciudad 2", "Ciudad 3")
    var selectedText by remember { mutableStateOf("") }
    var dropDownWidth by remember { mutableStateOf(0) }

    val icon = if (expanded) Icons.Filled.ArrowDropUp
    else Icons.Filled.ArrowDropDown

    Column(Modifier.padding(16.dp)) {
        OutlinedTextField(value = selectedText,
            onValueChange = { selectedText = it },
            modifier = Modifier
                .fillMaxWidth()
                .onSizeChanged {
                    dropDownWidth = it.width
                },
            label = { Text("Ciudad") },
            trailingIcon = {
                Icon(icon, "contentDescription", Modifier.clickable { expanded = !expanded })
            })
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.width(with(LocalDensity.current) { dropDownWidth.toDp() })
        ) {
            suggestions.forEach { label ->
                DropdownMenuItem(onClick = {
                    selectedText = label
                }) {
                    Text(text = label)
                }
            }
        }
    }
}


@Composable
fun BottomBottons() {
    Row(
        Modifier
            .fillMaxWidth()
            .padding(10.dp), horizontalArrangement = Arrangement.Center
    ) {
        Button(
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.pink)
            ),
            onClick = { /*TODO*/ },
            modifier = Modifier

                .weight(1f)
                .padding(8.dp),

            shape = Shapes.large
        ) {
            Icon(
                imageVector = Icons.Outlined.Backup,
                contentDescription = null,
                tint = Color.White
            )
            Spacer(Modifier.width(12.dp))
            Text(
                text = stringResource(id = R.string.document),
                fontSize = 14.sp,
                color = Color.White
            )
        }
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = colorResource(id = R.color.pink)
            ),
            modifier = Modifier

                .weight(1f)
                .padding(8.dp), shape = Shapes.large
        ) {
            Text(
                text = stringResource(id = R.string.send),
                color = Color.White,
                fontSize = 14.sp
            )
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun EnvioPreview() {
    ScreenSendDocuments()
}