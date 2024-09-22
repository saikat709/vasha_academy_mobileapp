package com.vashaacademy.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import coil.compose.AsyncImage

@Composable
fun TextImageOrBoth(
    modifier: Modifier = Modifier,
    optionText : String? = null,
    imageUrl: String? = null,
    number: Any = 1
) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = "$number",
            style = TextStyle(
                fontWeight = FontWeight.Black
            )
        )

        Column {
            if (optionText != null){
                Text(text = optionText)
            }
            if(imageUrl != null){
                AsyncImage(
                    model = imageUrl,
                    contentDescription = null,
                    placeholder = null,
                    error = null,
                )
            }
        }
    }
}

@Preview
@Composable
private fun TextImageOrBothPrev() {
    TextImageOrBoth()
}