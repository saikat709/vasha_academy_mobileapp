package com.vashaacademy.components

import android.app.Activity
import android.icu.text.CaseMap.Title
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.vashaacademy.backend.PdfBook
import com.vashaacademy.viewmodels.LangViewModel

@Composable
fun SinglePdfListTile(
    modifier: Modifier = Modifier,
    pdfBook: PdfBook,
    onReadClick: (PdfBook)->Unit,
    langViewModel:LangViewModel = viewModel<LangViewModel>()
) {
    val isEnglish by langViewModel.isEnglish.observeAsState()

    val abc = (LocalContext.current as Activity).codeCacheDir.toPath().toString()
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
            .clip(RoundedCornerShape(15.dp))
            .background(
                color = Color.Gray.copy(0.15f),
                shape = RoundedCornerShape(15.dp)
            )
            .padding(12.dp)
    ){
        Text(
            text= pdfBook.title,
            style=TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        )
//        Text(
//            text= "Some deatils of the book $abc",
//        )

        Spacer(modifier = Modifier.height(5.dp))

        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .fillMaxWidth()

        ){
            OutlinedButton(
                onClick = {onReadClick(pdfBook)}
            ) {
                Text(if(isEnglish == true) "Read" else "পড়ুন")
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun SinglePdfListTilePrev(modifier: Modifier = Modifier) {
//    SinglePdfListTile()
}