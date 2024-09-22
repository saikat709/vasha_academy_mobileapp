package com.vashaacademy.screens

import android.app.Activity
import android.content.pm.ActivityInfo
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.vashaacademy.components.ExamTile
import com.vashaacademy.constants.Screen

@Composable
fun CourseScreen(navController: NavHostController? = null) {

    val activity = LocalContext.current as Activity
    activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED

    val scrollState = rememberScrollState();

    Scaffold{
        Column(
            modifier = Modifier
                .verticalScroll(scrollState)
                .padding(it)
                .padding(10.dp)
                .safeContentPadding()
        ){
            Text(
                text = "2. 35 Set Packges (EPS 2024)",
                style = TextStyle(
                    fontWeight = FontWeight.Bold,
                    fontSize = 27.sp
                )
            )
            Text(text = "Question from Manufacture 1st and 2nd shift")

            (1..23).forEach { _ ->
                ExamTile(
                    onStart = { navController?.navigate(Screen.Exam.route) }
                )
            }
        }
    }
}

@Preview
@Composable
fun CourseScreenPrev() {
    CourseScreen()
}