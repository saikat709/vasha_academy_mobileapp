package com.vashaacademy.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UserTile(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.CenterVertically
    ){

        if(true){
            Icon(
                imageVector = Icons.Filled.AccountCircle,
                contentDescription = "",
                tint =  MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.size(56.dp)
            )
        }else {
            Image(
                imageVector = Icons.Filled.AccountCircle,
                contentDescription = "",
                modifier = Modifier
                    .size(56.dp)
                    .clip(CircleShape)
                    .background(
                        color = Color.Magenta,
                        shape = CircleShape
                    )
            )
        }
        Box(modifier = Modifier
            .width(10.dp)
        )
        Column {
            Text(
                text = "Saikat Islam",
                overflow = TextOverflow.Ellipsis,
            )
            Text(
                text="saikat709@gmail.com",
                style= TextStyle(
                    fontSize = 13.sp
                ),
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Preview
@Composable
private fun UserTilePrev() {
    UserTile()
}