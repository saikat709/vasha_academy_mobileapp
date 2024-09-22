package com.vashaacademy.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Options(
    modifier: Modifier = Modifier,
    options: List<String>
) {
    LazyColumn(
        modifier = Modifier
            .then(modifier)
//            .padding(all = 10.dp),
    ){
        items(options){
            Row {
                Text(text = "A.",
                    fontWeight = FontWeight.Bold,
                    fontSize = 19.sp
                )
                TextImageOrBoth(optionText = "sailboat option here")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun OptionPrev() {
    Options(options = listOf("29", "2882"))

}