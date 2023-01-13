package com.example.challengesophos.views


import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.challengesophos.R
import com.example.challengesophos.ui.theme.Shapes

@Composable
fun ScreenMain(navigationController: NavHostController, orEmpty: String) {
    Scaffold(
        topBar = {
            NavigationTop(orEmpty)
        }) {
        Column(
            Modifier
                .fillMaxSize()
                .fillMaxWidth()
        ) {
            TopImage()
            Spacer(modifier = Modifier.height(24.dp))
            SendDocuments(navigationController)
            Spacer(modifier = Modifier.height(20.dp))
            ShowDocuments(navigationController)
            Spacer(modifier = Modifier.height(24.dp))
            Office(navigationController)
        }
    }
}


@Composable
fun NavigationTop(name:String) {
    TopAppBar(
        title = {
            Text(
                text =name,
                Modifier
                    .padding(horizontal = 12.dp)
            )
        },
        backgroundColor = Color(0xFFFEFEFE),
        actions = {
            Icon(
                imageVector = Icons.Filled.Menu,
                contentDescription = "Menú",
               // tint = Color(0xFF7800FD),
                Modifier.padding(horizontal = 12.dp)
            )
        }
    )
}

@Composable
fun TopImage() {
    Image(
        painter = painterResource(id = R.drawable.plantilla_corporativa_2022_1),
        contentDescription = "welcome Image",
        modifier = Modifier.size(400.dp, height = 250.dp)
    )
}

@Composable
fun SendDocuments(navController: NavHostController) {
    Card(
        modifier = Modifier.padding(horizontal = 16.dp),
        shape = Shapes.large,
        border = BorderStroke(2.dp, color = colorResource(id = R.color.pink))
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(18.dp)
        ) {
            Row(Modifier.fillMaxWidth()) {
                Icon(
                    imageVector = Icons.Default.Description,
                    contentDescription = null,
                    Modifier.size(30.dp),
                    tint = colorResource(id = R.color.pink)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = stringResource(id = R.string.send_docs),
                    fontSize = 18.sp, color = colorResource(id = R.color.pink),
                    fontWeight = FontWeight.W600
                )
            }
            OutlinedButton(
                onClick = {navController.navigate("screenSendDocument") },
                Modifier.align(Alignment.End),
                border = BorderStroke(2.dp, color = colorResource(id = R.color.pink)),
                shape = Shapes.large,

                ) {
                Text(
                    text = stringResource(id = R.string.get_into),
                    
                    fontSize = 16.sp, color =colorResource(id = R.color.pink)
                )
                Spacer(modifier = Modifier.width(12.dp))
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = null, tint = colorResource(id = R.color.pink)
                )
            }
        }
    }
}


@Composable
fun ShowDocuments(navController: NavHostController) {
    Card(
        modifier = Modifier.padding(horizontal = 16.dp),
        shape = Shapes.large,
        border = BorderStroke(2.dp, color = colorResource(id = R.color.blue))
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(18.dp)
        ) {
            Row(Modifier.fillMaxWidth()) {
                Icon(
                    imageVector = Icons.Default.FindInPage,
                    contentDescription = null, Modifier.size(30.dp),
                    tint = colorResource(id = R.color.blue)
                )
                Spacer(modifier = (Modifier.width(8.dp)))
                Text(
                    text = stringResource(id = R.string.show_docs), fontSize = 18.sp, color = colorResource(id = R.color.blue),
                    fontWeight = FontWeight.W600
                )
            }
            OutlinedButton(
                onClick = { navController.navigate("screenConsultDocuments") },
                Modifier.align(Alignment.End),
                border = BorderStroke(2.dp, color = colorResource(id = R.color.blue)),
                shape = Shapes.large,
            ) {
                Text(text = stringResource(id = R.string.get_into), fontSize = 16.sp)
                Spacer(modifier = Modifier.width(12.dp))
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = null, tint = colorResource(id = R.color.blue)
                )
            }
        }
    }
}


@Composable
fun Office(navController:NavHostController) {
    Card(
        modifier = Modifier.padding(horizontal = 16.dp),
        shape = Shapes.large,
        border = BorderStroke(2.dp, color = colorResource(id = R.color.green))
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .padding(18.dp)
        ) {
            Row(Modifier.fillMaxWidth()) {
                Icon(
                    imageVector = Icons.Default.LocationOn,
                    contentDescription = null, Modifier.size(30.dp),
                    tint = colorResource(id = R.color.green)
                )
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = stringResource(id = R.string.office),
                    fontSize = 18.sp, color = colorResource(id = R.color.green),
                    fontWeight = FontWeight.W600
                )
            }
            OutlinedButton(
                onClick = { navController.navigate("screenOfficeMap")       },
                Modifier.align(Alignment.End),
                border = BorderStroke(2.dp, color = colorResource(id = R.color.green)),
                shape = Shapes.large,
            ) {
                Text(
                    text = stringResource(id = R.string.get_into),
                    fontSize = 16.sp,
                    color = colorResource(id = R.color.green),

                )

                Spacer(modifier = Modifier.width(12.dp))
                Icon(
                    imageVector = Icons.Default.ArrowForward,
                    contentDescription = null, tint = colorResource(id = R.color.green)
                )
            }
        }
    }
}






