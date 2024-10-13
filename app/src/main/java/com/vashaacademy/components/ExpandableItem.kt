package com.vashaacademy.components

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.TweenSpec
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun ExpandableItem(
    modifier: Modifier = Modifier,
    headlineContent: @Composable ()-> Unit,
    innerContent: @Composable ()-> Unit,
) {
    var isExpanded by remember { mutableStateOf(false) }
    val rotation by animateFloatAsState(
        targetValue = if(isExpanded) 180f else 0f,
        animationSpec = TweenSpec(durationMillis = 300)
    )

    Column(
        modifier = Modifier.animateContentSize(
                    animationSpec = TweenSpec(durationMillis = 150)
                )
                .then(modifier)
    ){
        ListItem(
            headlineContent = { headlineContent() },
            trailingContent = {
                Icon(
                    imageVector = Icons.Default.ArrowDropDown,
                    contentDescription = " ",
                    modifier = Modifier.rotate(rotation)
                )
            },
            modifier = Modifier.clickable {
                isExpanded = !isExpanded
            }
        )

        if (isExpanded){
            innerContent()
        }
    }
}


@Preview
@Composable
private fun ExPrev() {
    ExpandableItem(
        headlineContent = { Text("head") }
    ) {
        Text("Body")
    }
}