package com.vashaacademy.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Option(
    modifier: Modifier = Modifier,
    options: List<String>
) {
    LazyColumn(
        modifier = Modifier
            .then(modifier)
            .padding(all = 10.dp),
    ){
        items(options){
            Row {
                
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun OptionPrev() {
    Option(options = listOf("29", "2882"))

}