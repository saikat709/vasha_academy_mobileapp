package com.vashaacademy.components

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.SegmentedButton
import androidx.compose.material3.SingleChoiceSegmentedButtonRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.tooling.preview.Preview
import com.vashaacademy.constants.BANGLA
import com.vashaacademy.constants.ENGLISH

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LanguageSelection(modifier: Modifier = Modifier) {

    var selectedLang by remember { mutableStateOf(ENGLISH) }

    SingleChoiceSegmentedButtonRow{
        SegmentedButton(
            selected = selectedLang == ENGLISH,
            shape = RectangleShape,
            onClick = {
                selectedLang = ENGLISH
            }
        ) {
            Text(ENGLISH.uppercase())
        }
        SegmentedButton(
            selected = selectedLang == BANGLA,
            onClick = {
                selectedLang = BANGLA
            },
            shape = RectangleShape,
        ) {
            Text(BANGLA.uppercase())
        }
    }
}

@Preview
@Composable
private fun LanguageSelectionPrev() {
    LanguageSelection()
}