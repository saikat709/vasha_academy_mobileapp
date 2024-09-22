package com.vashaacademy.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Question(
    modifier: Modifier = Modifier, questionNo: Int
) {
    Row(
        modifier = Modifier
            .then(modifier)
            .padding(all = 10.dp),
    ){
        Text(text = "$questionNo. ",
            fontSize = 24.sp,
            fontWeight = FontWeight.ExtraBold
        )

        TextImageOrBoth(
            optionText = "What is Your name man?"
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun QuestionPrev() {
    Question(questionNo = 10)
}