package com.vashaacademy.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NextPreviuosRow(modifier: Modifier = Modifier) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        OutlinedButton( onClick = {} ) {
            Text(text = "Previous")
        }
        OutlinedButton( onClick = {} ) {
            Text(text = "Total Questions")
        }
        OutlinedButton( onClick = {} ) {
            Text(text = "Next")
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun NextPreviousRowPrev() {
    NextPreviuosRow()
}