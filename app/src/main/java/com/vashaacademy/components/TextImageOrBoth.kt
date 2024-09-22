package com.vashaacademy.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage

@Composable
fun TextImageOrBoth(
    modifier: Modifier = Modifier,
    optionText : String? = "This is Question text",
    imageUrl: String? = "https://media.istockphoto.com/id/1696167872/photo/aerial-view-of-forest-at-sunset-on-the-background-of-mountains-in-dolomites.jpg?s=612x612&w=is&k=20&c=mW0RiTTyqnRnmuIq4OfqIpRqCtPNqtaoTG_DUDzDCSQ=",
){

    Column(
        modifier = Modifier
            .then(modifier)
            .padding(horizontal = 10.dp)
            .padding(bottom = 1.dp)
    ){
        if (optionText != null){
            Text(
                text = optionText,
                fontSize = 18.sp
            )
        }
        if(imageUrl != null){
            AsyncImage(
                model = imageUrl,
                contentDescription = null,
                placeholder = null,
                error = null,
                modifier = Modifier
                    .padding(top = 2.dp)
                    .height(90.dp)
            )
        }
    }

}

@Preview
@Composable
private fun TextImageOrBothPrev() {
    TextImageOrBoth()
}