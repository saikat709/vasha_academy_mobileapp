package com.vashaacademy.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.sharp.Favorite
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarWithInfo(modifier: Modifier = Modifier) {
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = {}) {
                Icon(
                    imageVector=Icons.Default.Menu,
                    contentDescription = "",
                )
            }
        },
        title = {
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
                       )
                   )
               }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary,
            titleContentColor = MaterialTheme.colorScheme.onPrimary,
            actionIconContentColor = MaterialTheme.colorScheme.onPrimary,
            navigationIconContentColor =  MaterialTheme.colorScheme.onPrimary,
        )
    )
}

@Composable
@Preview
fun TopBarWithInfoPrev(modifier: Modifier = Modifier) {
    TopBarWithInfo()
}