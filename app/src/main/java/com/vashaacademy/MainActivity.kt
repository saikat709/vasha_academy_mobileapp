package com.vashaacademy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.vashaacademy.navigation.SetUpNavHost
import com.vashaacademy.ui.theme.VashaAcademyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VashaAcademyTheme(
                darkTheme = true
            ){
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    print(innerPadding)
                    val navController = rememberNavController()
                    //WelcomeScreen()
                    //HomeScreen()
                    //LoginScreen()
                    //VerificationScreen()
                    SetUpNavHost(navController = navController)
                }
            }
        }
    }
}
