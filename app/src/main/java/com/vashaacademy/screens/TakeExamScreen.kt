package com.vashaacademy.screens

import android.app.Activity
import android.content.pm.ActivityInfo
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.vashaacademy.constants.Screen

@Composable
fun TakeExamScreen(navController:NavHostController?=null) {
    val activity = LocalContext.current as Activity
    activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE
    Scaffold {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .clickable {
                    navController?.navigate(route = Screen.Home.route)
                }
        ) {
            Text(text = "Saikattttttt.......")

        }
    }
}

@Preview()
@Composable
fun TakeExamScreenPrev() {
    TakeExamScreen()
}