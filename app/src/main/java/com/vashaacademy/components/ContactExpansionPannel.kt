package com.vashaacademy.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.ThumbUp
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ContactExpansionPannel(modifier: Modifier = Modifier) {

    var isExpanded by remember { mutableStateOf(false) }
    val rotation by animateFloatAsState(
        targetValue = if (isExpanded) 1f else 0f,
        animationSpec = tween(
            durationMillis = 200
        )
    )
    Column(
        modifier = Modifier
            .animateContentSize(
                animationSpec = tween(
                    durationMillis = 200
                )
            )
    ){
        ListItem(
            headlineContent = {
                Text("Contact us")
            },
            trailingContent = {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    contentDescription = "",
                    modifier = Modifier
                        .rotate(degrees = 180*rotation)
                )
            },
            leadingContent = {
                Icon(
                    imageVector = Icons.Default.AccountCircle,
                    contentDescription = "",
                )
            },
            modifier = Modifier
                .clickable {
                    isExpanded = !isExpanded
                }
        )
        if (isExpanded){
            Column(
                modifier = Modifier.padding(start = 30.dp)
            ){
                ListItem(
                    headlineContent = { Text("Phone") },
                    leadingContent = { Icon(imageVector = Icons.Default.Call, contentDescription = "") }
                )
                ListItem(
                    headlineContent = { Text("WhatsApp") },
                    leadingContent = { Icon(imageVector = Icons.Default.Call, contentDescription = "") }
                )
                ListItem(
                    headlineContent = { Text("Messenger") },
                    leadingContent = { Icon(imageVector = Icons.Default.ThumbUp, contentDescription = "") }
                )
            }
        }
    }
}

@Preview
@Composable
private fun ContactExpansionPannelPrev() {
    ContactExpansionPannel()
}