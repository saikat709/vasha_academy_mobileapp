package com.vashaacademy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.downloader.PRDownloader
import com.downloader.PRDownloaderConfig
import com.vashaacademy.navigation.SetUpNavHost
import com.vashaacademy.screens.HomeScreenWithDrawer
import com.vashaacademy.screens.TakeExamScreen
import com.vashaacademy.screens.WelcomeScreen
import com.vashaacademy.ui.theme.VashaAcademyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val config = PRDownloaderConfig.Builder()
            .setDatabaseEnabled(true)
            .build()
        PRDownloader.initialize(applicationContext, config)
        enableEdgeToEdge()
        setContent {
            VashaAcademyTheme(
                darkTheme = true
            ){
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    print(innerPadding)
                    val navController = rememberNavController()
//                    SetUpNavHost(navController = navController)
//                    WelcomeScreen()
//                    HomeScreenWithDrawer()
                    TakeExamScreen()
                }
            }
        }
    }
}
