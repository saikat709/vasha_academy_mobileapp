package com.vashaacademy.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.vashaacademy.R

@Composable
fun QuestionViewScreen(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier.then(modifier)
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(15.dp)
        ){
            Text(text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold
                    )
                ){
                    append("1. ")
                }

                withStyle(
                    style = SpanStyle(
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Normal
                    )
                ){
                    append("Question")
                }
            })

            Spacer(modifier = Modifier.height(20.dp))

            FilledTonalButton(onClick = { /*TODO*/ }) {
                Icon(painter = painterResource(id = R.drawable.read), contentDescription = "")
                
            }
        }
        Column {
            listOf("A", "B", "C", "D").forEach {
                Text("Option $it")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun QuestionViewScreenPrev() {
    QuestionViewScreen()
}