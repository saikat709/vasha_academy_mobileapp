package com.vashaacademy.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.vashaacademy.components.SinglePdfListTile

@Composable
fun PdfsPartialScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .then(modifier)
    ){
        SinglePdfListTile()
        SinglePdfListTile()
        SinglePdfListTile()
    }
}

@Composable
@Preview(showBackground=true)
fun PdfsPartialScreenPrev(modifier: Modifier = Modifier) {
    PdfsPartialScreen()
}