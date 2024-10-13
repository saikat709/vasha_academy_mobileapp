package com.vashaacademy.screens

import android.annotation.SuppressLint
import android.content.res.AssetManager
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.isTraceInProgress
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavHostController
import com.rizzi.bouquet.ResourceType
import com.rizzi.bouquet.VerticalPDFReader
import com.rizzi.bouquet.rememberVerticalPdfReaderState

import com.vashaacademy.R
import java.io.File
import kotlin.system.exitProcess

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("ResourceType")
@Composable
fun ReadPdfScreen(
    modifier: Modifier = Modifier,
    pdfLink: String,
    pdfTitle: String = "Book title",
    navController: NavHostController
) {
    val pdfState = rememberVerticalPdfReaderState(
        resource = ResourceType.Remote(pdfLink),
        isZoomEnable = true,
    )
    val context = LocalContext.current.applicationContext

    LaunchedEffect(pdfState.error) {
        pdfState.error?.let {
            Toast.makeText(context, it.message.toString(), Toast.LENGTH_SHORT).show()
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(pdfTitle)},
                navigationIcon = {
                    IconButton(
                        onClick = { navController.popBackStack() }
                    ) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = " ")
                    }
                }
            )
        }
    ){
        VerticalPDFReader(
            state = pdfState,
            modifier = Modifier.padding(it)
        )

    }

}