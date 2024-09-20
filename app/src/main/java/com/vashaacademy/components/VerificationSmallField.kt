package com.vashaacademy.components

import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp

@Composable
fun VerificationSmallField(
    modifier: Modifier = Modifier,
    last: Boolean = false
) {
    var num by remember { mutableStateOf("") }
    OutlinedTextField(
        value = num,
        onValueChange = {
            if (it.length <= 1) num = it
        },
        maxLines = 1,
        keyboardOptions = KeyboardOptions(
            imeAction = if (last) ImeAction.Done else ImeAction.Next,
            keyboardType = KeyboardType.Phone
        ),
        modifier = Modifier
            .size(56.dp)
    )
}


@Composable
fun VerificationSmallFieldPrev(modifier: Modifier = Modifier) {
    VerificationSmallField()
}