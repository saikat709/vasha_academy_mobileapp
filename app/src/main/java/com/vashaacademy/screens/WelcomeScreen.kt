package com.vashaacademy.screens

import com.vashaacademy.R
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.vashaacademy.constants.BANGLA
import com.vashaacademy.constants.ENGLISH
import com.vashaacademy.constants.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController? = null
    ) {

    var selectedLang by remember { mutableStateOf(ENGLISH) }

    Column(
        modifier = Modifier
            .then(modifier)
            .fillMaxSize()
            .padding(vertical=200.dp),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
    ){
        Image(
            painter = painterResource(R.drawable.logo),
            contentDescription = "logo",
            modifier = Modifier
                .size(200.dp)
                .clip(CircleShape)
        )

        SingleChoiceSegmentedButtonRow{
            SegmentedButton(
                selected = selectedLang == ENGLISH,
                shape = RectangleShape,
                onClick = {
                    selectedLang = ENGLISH
                }
            ) { 
                Text(ENGLISH.uppercase())
            }
            SegmentedButton(
                selected = selectedLang == BANGLA,
                onClick = {
                    selectedLang = BANGLA
                },
                shape = RectangleShape,
            ) {
                Text(BANGLA.uppercase())
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        ElevatedButton(
            onClick = {
                navController?.navigate(route= Screen.Login.route)
            },
            modifier=Modifier.scale(1.5f, 1f)
        ) {
            Text(text="Go Next")
        }
    }
}

@Composable
@Preview
fun WelcomeScreenPrev(modifier: Modifier = Modifier) {
    WelcomeScreen()
}