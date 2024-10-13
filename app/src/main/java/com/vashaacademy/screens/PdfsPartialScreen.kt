package com.vashaacademy.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.vashaacademy.backend.Api
import com.vashaacademy.backend.PdfBook
import com.vashaacademy.components.SinglePdfListTile
import com.vashaacademy.constants.Screen

@Composable
fun PdfsPartialScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController? = null
) {
    var pdfs: List<PdfBook>? by remember { mutableStateOf(null) }
    LaunchedEffect(Unit) {
        val res = Api.getInstance().getPdfBooks()
        if(res.isSuccess){
            pdfs = res.getOrNull()
        }
    }
    LazyColumn(
        modifier = Modifier
            .then(modifier)
    ){
        pdfs?.let {
            items(it.size) {
                val pdf = pdfs!![it]
                SinglePdfListTile(
                    pdfBook = pdf,
                    onReadClick = {
                        navController?.navigate(Screen.ReadPdf.getUrl(pdfBook = pdf))
                    }
                )
            }
        }
        if (pdfs == null){
            item{
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                ){
                    Text("To pdf found.",
                        modifier = Modifier.align(Alignment.Center)
                    )
                }
            }
        }
    }
}

@Composable
@Preview(showBackground=true)
fun PdfsPartialScreenPrev(modifier: Modifier = Modifier) {
    PdfsPartialScreen()
}