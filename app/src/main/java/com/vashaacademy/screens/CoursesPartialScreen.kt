package com.vashaacademy.screens

import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vashaacademy.components.CourseTile


@Composable
fun CoursesPartialScreen(modifier: Modifier = Modifier) {
    LazyVerticalGrid(
        modifier = Modifier.then(modifier),
        columns = GridCells.Fixed(2),
    ) {
        items(20){
            CourseTile()
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CoursesPartialScreenPrev(modifier: Modifier = Modifier) {
    CoursesPartialScreen()
}