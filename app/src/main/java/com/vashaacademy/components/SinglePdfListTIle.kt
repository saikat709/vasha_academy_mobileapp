package com.vashaacademy.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SinglePdfListTile(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(
                color = Color.Gray.copy(0.15f),
                shape = RoundedCornerShape(15.dp)
            )
            .padding(12.dp)
    ){
        Text(
            text="Name of the pdf book",
            style=TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 22.sp
            )
        )
        Text(
            text="Some deatils of the book",
        )

        Spacer(modifier = Modifier.height(5.dp))

        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .fillMaxWidth()

        ){
            OutlinedButton(
                onClick = {}
            ) {
                Text("Read here")
            }

            Spacer(modifier = Modifier.width(10.dp))

            OutlinedButton(
                onClick = {}
            ) {
                Text("Download")
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun SinglePdfListTilePrev(modifier: Modifier = Modifier) {
    SinglePdfListTile()
}