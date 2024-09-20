package com.vashaacademy.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun CourseTile() {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
            .background(
                color = Color.Gray.copy(0.15f),
                shape = RoundedCornerShape(5.dp)
            )
            .padding(10.dp)
    ){
        Text(text = "Course Name",
            style = TextStyle(
                fontWeight = FontWeight.Bold
            )
        )
        Spacer(modifier = Modifier.height(15.dp))
        Text(text = "According to ABC courses.",
            style = TextStyle(
                fontSize = 14.sp
            )
        )
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ){
//            TextButton(onClick = { /*TODO*/ }) {
//                Text(text = "Preview" )
//            }
            TextButton(onClick = { /*TODO*/ }) {
                Text(text = "Enroll")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CourseTilePrev() {
    CourseTile()
}