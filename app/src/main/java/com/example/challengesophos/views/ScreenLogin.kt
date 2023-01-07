package com.example.challengesophos.login


import android.app.Activity
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.challengesophos.R
import com.example.challengesophos.model.LoginClient
import com.example.challengesophos.view_model.LoginViewModel

@Composable
fun ScreenLogin(loginViewModel: LoginViewModel, navigationController: NavHostController) {
    Box(
        Modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        Close(Modifier.align(Alignment.TopEnd))
        Body(Modifier.align(Alignment.Center), loginViewModel, navigationController)

    }
}

@Composable
fun Close(modifier: Modifier) {
    val activity = LocalContext.current as Activity
    Icon(
        tint = colorResource(id = R.color.purple),
        imageVector = Icons.Default.Close,
        contentDescription = "close",
        modifier = modifier.clickable {
            activity.finish()
        }
    )
}

@Composable
fun Body(
    modifier: Modifier,
    loginViewModel: LoginViewModel,
    navigationController: NavHostController
) {
    val email: String by loginViewModel.email.observeAsState(initial = "")
    val password: String by loginViewModel.password.observeAsState(initial = "")

    Column(modifier = modifier) {
        ImageHeader(Modifier.align(Alignment.CenterHorizontally))
        Spacer(modifier = Modifier.size(16.dp))
        HeaderText()
        Spacer(modifier = Modifier.size(16.dp))
        InputEmail(email) {
            loginViewModel.onLoginChanged(email = it, password = password)
        }
        Spacer(modifier = Modifier.size(16.dp))
        InputPassword(password) {
            loginViewModel.onLoginChanged(email = email, password = it)
        }
        Spacer(modifier = Modifier.size(24.dp))
        LoginButton(navigationController)
        Spacer(modifier = Modifier.size(16.dp))
        BiometricButton()
    }
}

@Composable
fun ImageHeader(modifier: Modifier) {
    Image(
        painter = painterResource(R.drawable.logosophos),
        contentDescription = "Logo Sophos",
        contentScale = ContentScale.Fit,
        modifier = modifier.size(width = 300.dp, height = 150.dp)
    )
}

@Composable
fun HeaderText() {
    Text(
        text = stringResource(id = R.string.header_text),
        color = colorResource(id = R.color.purple),
        fontSize = 18.sp, fontWeight = FontWeight.W600,
        textAlign = TextAlign.Center,
        modifier = Modifier.padding(horizontal = 80.dp)
    )
}

@Composable
fun InputEmail(email: String, onTextChanged: (String) -> Unit) {
    TextField(
        value = email,
        onValueChange = { onTextChanged(it) },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Mail,
                contentDescription = null, tint = colorResource(id = R.color.purple)
            )

        },
        modifier = Modifier
            .fillMaxWidth()
            .border(
                2.dp, SolidColor(colorResource(id = R.color.purple)),
                MaterialTheme.shapes.large
            ),
        placeholder = {
            Text(
                text = stringResource(id = R.string.email),
                fontSize = 16.sp,
                color = colorResource(id = R.color.purple)
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = colorResource(id = R.color.purple),
            backgroundColor = Color.White,
            unfocusedIndicatorColor = Color.Transparent,
            focusedIndicatorColor = Color.Transparent
        )
    )
}

@Composable
fun InputPassword(password: String, onTextChanged: (String) -> Unit) {
    var passwordVisibility by remember { mutableStateOf(false) }
    TextField(
        value = password, onValueChange = { onTextChanged(it) },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.VpnKey,
                contentDescription = null,
                tint = colorResource(id = R.color.purple)
            )
        },
        trailingIcon = {
            val image = if (passwordVisibility) {
                Icons.Default.VisibilityOff
            } else {
                Icons.Default.Visibility
            }

            IconButton(onClick = { passwordVisibility = !passwordVisibility }) {
                Icon(
                    imageVector = image,
                    contentDescription = "Show Password",
                    tint = colorResource(id = R.color.purple)
                )
            }
        },
        visualTransformation = if (passwordVisibility) {
            VisualTransformation.None
        } else {
            PasswordVisualTransformation()
        },
        modifier = Modifier
            .fillMaxWidth()
            .border(
                2.dp, SolidColor(colorResource(id = R.color.purple)),
                MaterialTheme.shapes.large
            ),
        placeholder = {
            Text(
                text = stringResource(R.string.password),
                fontSize = 16.sp,
                color = colorResource(id = R.color.purple)
            )
        },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        singleLine = true,
        maxLines = 1,
        colors = TextFieldDefaults.textFieldColors(
            textColor = colorResource(id = R.color.purple),
            backgroundColor = Color.White,
            focusedLabelColor = colorResource(id = R.color.purple),
            focusedIndicatorColor = Color.Transparent
        )
    )
}



@Composable
fun LoginButton(navigationController: NavHostController) {

    Button(
        onClick = {
           
            navigationController.navigate("screenMain/Daniela")
        },
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp),
        shape = MaterialTheme.shapes.large,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = colorResource(id = R.color.purple),
            contentColor = Color.White

        )
    ) {
        Text(
            stringResource(id = R.string.get_into),
            fontSize = 18.sp
        )
    }
}


@Composable
fun BiometricButton() {
    OutlinedButton(
        onClick = { /*TODO*/ },
        Modifier
            .fillMaxWidth()
            .height(48.dp),
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Color.White,
            contentColor = colorResource(id = R.color.purple)
        ),
        border = BorderStroke(2.dp, color = colorResource(id = R.color.purple)),
        shape = MaterialTheme.shapes.large
    ) {
        Icon(painterResource(id = R.drawable.fingerprint), contentDescription = null)
        Spacer(modifier = Modifier.width(24.dp))
        Text(
            text = stringResource(R.string.biometric),
            fontSize = 18.sp
        )
    }
}

@Composable
fun MySpacer(size: Int) {
    Spacer(modifier = Modifier.height((size.dp)))
}




