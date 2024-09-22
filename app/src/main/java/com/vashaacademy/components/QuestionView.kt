package com.vashaacademy.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vashaacademy.R

@Composable
fun QuestionViewScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .then(modifier)
            .fillMaxSize(1f)
            .padding(5.dp)
    ){
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.75f)
                .padding(10.dp)
                .padding(start = 10.dp)
        ){
            val scrollState = rememberScrollState()
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.5f)
                    .verticalScroll(scrollState)
                    .padding(end = 10.dp)
            ){

                Question(questionNo = 20)
                Spacer(modifier = Modifier.height(20.dp))
                ElevatedButton(
                    onClick = { /*TODO*/ }
                ) {
                    Icon(painter = painterResource(id = R.drawable.read), contentDescription = "")
                    Spacer(modifier=Modifier.width(15.dp))
                    Text("Listen")
                }
            }
            Column {
                Options(options = listOf("28", "298", "quit"))
            }
        }
        NextPreviuosRow()
    }
}


@Preview(showBackground = true, )
@Composable
fun QuestionViewScreenPrev() {
    QuestionViewScreen()
}