package com.vashaacademy.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.vashaacademy.constants.CurrentQuestionType

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ExamScreenTabs(
    modifier: Modifier = Modifier,
    onNavBack: ()->Unit,
) {
    var activeTab by remember { mutableStateOf(CurrentQuestionType.Total) }

    Row(
        modifier = Modifier
            .height(55.dp)
            .fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        IconButton(onClick = { onNavBack() }) {
            Icon(
                imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft,
                contentDescription = "",
            )
        }
        UserTile()
        Spacer(modifier = Modifier.width(15.dp))

        TabTile(
            text = "Total Question",
            onTabChange = {
                activeTab = CurrentQuestionType.Total },
            currentQuestionType = activeTab,
            selftype = CurrentQuestionType.Total
        )

        TabTile(
            text = "Solved Question",
            onTabChange = {activeTab = CurrentQuestionType.Solved},
            currentQuestionType = activeTab,
            selftype = CurrentQuestionType.Solved
        )

        TabTile(
            text = "Unsolved Question",
            onTabChange = {activeTab = CurrentQuestionType.UnSolved},
            currentQuestionType = activeTab,
            selftype = CurrentQuestionType.UnSolved
        )

        Box(
            modifier = Modifier
                .fillMaxHeight()
                .width(150.dp)
                .padding(5.dp),
            contentAlignment = Alignment.Center,
        ){
            Text("43:65")
        }
    }


}


@Composable
private fun TabTile(
    modifier: Modifier = Modifier,
    text: String,
    onTabChange: (CurrentQuestionType) -> Unit,
    currentQuestionType: CurrentQuestionType,
    selftype:CurrentQuestionType,
) {
    Box(
        modifier = Modifier
            .fillMaxHeight()
            .background(
                color = if (currentQuestionType == selftype) Color.Blue.copy(0.85f)
                        else Color.Transparent
            )
            .padding(5.dp)
            .clip(shape = RoundedCornerShape(3.dp))
            .clickable {
                onTabChange(selftype)
            },

        contentAlignment = Alignment.Center,
    ){
        Text(text = text)
    }
}

@Preview
@Composable
private fun ExamScreenTabsPrev() {
   // ExamScreenTabs(onNavBack = {})
}