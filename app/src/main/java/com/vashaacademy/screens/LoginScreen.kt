package com.vashaacademy.screens

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.widget.TextView
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import com.vashaacademy.R
import com.vashaacademy.constants.Screen

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController? = null
) {
    
    var nameField by remember { mutableStateOf("") }
    var numberField by remember { mutableStateOf("") }
    var passwordField by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .then(modifier)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "logo",
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
        )

        Spacer(modifier = Modifier.height(21.dp))
        
        OutlinedTextField(
            value = nameField,
            onValueChange = {
                nameField = it
            },
            label = { Text("Name") },
            maxLines = 1,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Text
            )
        )

        OutlinedTextField(
            value = numberField,
            onValueChange = {
                numberField = it
            },
            label = { Text("Phone Number") },
            maxLines = 1,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Number
            )
        )

        OutlinedTextField(
            value = passwordField,
            onValueChange = {
                passwordField = it
            },
            label = { Text("Passsword") },
            maxLines = 1,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Password
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        ElevatedButton(
            onClick = {
                navController?.navigate(route= Screen.Verification.route)
            }
        ) {
            Text(text="Login/Register")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = "Contact: 0521771635",
//            modifier = Modifier.fillMaxWidth(0.7f),
            textAlign = TextAlign.Left,
        )
    }
}

@Composable
@Preview(showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
fun LoginScreenPrev(modifier: Modifier = Modifier) {
    LoginScreen()
}