package com.vashaacademy.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.vashaacademy.components.VerificationSmallField
import com.vashaacademy.constants.Screen
import com.vashaacademy.viewmodels.LangViewModel

@Composable
fun VerificationScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController? = null,
    langViewModel: LangViewModel = viewModel<LangViewModel>()
) {

    val isEnglish by langViewModel.isEnglish.observeAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Text(
            text=if (isEnglish == true) "Verification" else "ভেরিফিকেশন",
            color = MaterialTheme.colorScheme.primary,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 35.sp,
            )
        )

        Spacer(modifier= Modifier.height(55.dp))

        Row(
            modifier = Modifier,
                //.padding(horizontal = 20.dp),
            horizontalArrangement = Arrangement.spacedBy(10.dp)
        ){
            VerificationSmallField()
            VerificationSmallField()
            VerificationSmallField()
            VerificationSmallField( last = true )
        }

        Spacer(modifier= Modifier.height(15.dp))

        ElevatedButton(
            onClick = {
                navController?.navigate(route = Screen.Home.route)
            }
        ) {
            Text(text=if (isEnglish == true) "Login/Register" else "লগিন/রেজিস্টার")
        }

    }
}


@Composable
@Preview
fun VerificationScreenPrev(modifier: Modifier = Modifier) {
    VerificationScreen()
}
