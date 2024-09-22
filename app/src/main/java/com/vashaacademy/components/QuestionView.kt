package com.vashaacademy.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedCard
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
    val scrollState = rememberScrollState()
    Row(
        modifier = Modifier
            .then(modifier)
            .fillMaxSize()
    ){
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .verticalScroll(scrollState)
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
                    append("Question text goes here")
                }
            })

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
            TextImageOrBoth(imageUrl = "https://media.istockphoto.com/id/1696167872/photo/aerial-view-of-forest-at-sunset-on-the-background-of-mountains-in-dolomites.jpg?s=612x612&w=is&k=20&c=mW0RiTTyqnRnmuIq4OfqIpRqCtPNqtaoTG_DUDzDCSQ=")
        }
    }
}

@Composable
fun Button(onClick: () -> Unit, content: @Composable () -> Unit) {

}

@Preview(showBackground = true)
@Composable
fun QuestionViewScreenPrev() {
    QuestionViewScreen()
}