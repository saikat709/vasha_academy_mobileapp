package com.vashaacademy.screens

import android.content.Intent
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.vashaacademy.R
import com.vashaacademy.constants.Screen
import com.vashaacademy.viewmodels.LangViewModel

@Composable
fun LoginScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController? = null,
    langViewModel: LangViewModel = viewModel<LangViewModel>()
) {
    
    var nameField by remember { mutableStateOf("") }
    var numberField by remember { mutableStateOf("") }
    var passwordField by remember { mutableStateOf("") }

    val isEnglish by langViewModel.isEnglish.observeAsState()
    val number = stringResource(R.string.number_en)
    val context = LocalContext.current

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
            label = { Text(if (isEnglish == true) "Name" else "নাম") },
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
            label = { Text(if (isEnglish == true) "Phone Number" else "ফোন নাম্বার") },
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
            label = { Text(if (isEnglish == true) "Passsword" else "পাসও্যার্ড") },
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
            Text(text=if (isEnglish == true) "Login/Register" else "লগিন/রেজিস্টার")
        }

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            text = if (isEnglish == true) "Contact us: ${stringResource(R.string.number_en)}" else "যোগাযোগ করুনঃ ${stringResource(R.string.number_en)}",
            modifier = Modifier.clickable {
                val intend = Intent(Intent.ACTION_DIAL).apply {
                    setData(Uri.parse("tel:${number}"))
                }
                context.startActivity(intend)
            },
            style = TextStyle(textDecoration = TextDecoration.Underline),
            textAlign = TextAlign.Left,
        )
    }
}

@Composable
@Preview(showSystemUi = true, uiMode = UI_MODE_NIGHT_YES)
fun LoginScreenPrev(modifier: Modifier = Modifier) {
    LoginScreen()
}