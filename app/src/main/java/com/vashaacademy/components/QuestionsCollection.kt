package com.vashaacademy.components

import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun QuestionsCollection(onQuestionClick: (Int)-> Unit) {
    LazyVerticalGrid(
        columns = GridCells.Adaptive(100.dp),
    ){
        items(50){
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .size(90.dp)
                    .padding(5.dp)
                    .background(
                        color = Color.Gray.copy(alpha = 0.15f),
                        shape = RoundedCornerShape(10.dp)
                    )
                    .clickable {
                        onQuestionClick(it)
                    }
                    .padding(10.dp)
            ){
                Text(
                    text = "${it+1}",
                    style = TextStyle(
                        fontSize = 35.sp
                    )
                )
            }
        }
    }
}


@Preview(showSystemUi = true, uiMode = UI_MODE_NIGHT_YES, showBackground = true)
@Composable
fun QuestionsCollectionPrev() {
    QuestionsCollection(onQuestionClick = {})
}