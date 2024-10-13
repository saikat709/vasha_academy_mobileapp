package com.vashaacademy.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.vashaacademy.backend.Api
import com.vashaacademy.backend.Faq
import com.vashaacademy.backend.Notice
import com.vashaacademy.components.ExpandableItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FaqScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController? = null
) {
    var faqs: List<Faq>? by remember { mutableStateOf(null) }

    LaunchedEffect(Unit) {
        val res = Api.getInstance().getFaqs()
        if(res.isSuccess){
            faqs = res.getOrNull()
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Faqs") },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            if (navController != null) {
                                navController.popBackStack()
                            }
                        }
                    ) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = " ")
                    }
                }
            )
        }
    ){
        LazyColumn( modifier = Modifier.padding(it) ) {
            items(10){
                ExpandableItem(
                    headlineContent = { Text("head") }
                ) {
                    Text("Body")
                }
            }
        }

        if (faqs?.isEmpty() == true) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                Text(
                    "To Question found.",
                    modifier = Modifier.align(Alignment.Center)
                )
            }
        }

    }

}

@Preview
@Composable
private fun FaqScreenPrev() {
    FaqScreen()
}