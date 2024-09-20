package com.vashaacademy.screens

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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vashaacademy.components.ExamTile

@Composable
fun CourseScreen() {

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

            (1..100).forEach { _ ->
                ExamTile()
            }
        }
    }
}

@Preview
@Composable
fun CourseScreenPrev() {
    CourseScreen()
}