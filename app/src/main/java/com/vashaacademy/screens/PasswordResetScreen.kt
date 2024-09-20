package com.vashaacademy.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.vashaacademy.constants.Screen

@Composable
fun PasswordResetScreen(navController:NavHostController?=null) {

    var passwordField by remember { mutableStateOf("") }
    var passwordField1 by remember { mutableStateOf("") }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Reset Password",
            color = MaterialTheme.colorScheme.primary,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 35.sp,
            )
        )
        Spacer(modifier = Modifier.height(15.dp))
        OutlinedTextField(
            value = passwordField,
            onValueChange = {
                passwordField = it
            },
            label = { Text("New Password") },
            maxLines = 1,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Next,
                keyboardType = KeyboardType.Password
            )
        )
        OutlinedTextField(
            value = passwordField1,
            onValueChange = {
                passwordField1 = it
            },
            label = { Text("Re-Enter Password") },
            maxLines = 1,
            keyboardOptions = KeyboardOptions(
                imeAction = ImeAction.Done,
                keyboardType = KeyboardType.Password
            )
        )

        Spacer(modifier = Modifier.height(15.dp))

        ElevatedButton(
            onClick = {
                navController?.navigate(route= Screen.Verification.route)
            }
        ) {
            Text(text="Login/Register")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun PasswordResetScreenPrev() {
    PasswordResetScreen()
}