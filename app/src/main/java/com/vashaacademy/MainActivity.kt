package com.vashaacademy

import android.os.Bundle
import android.se.omapi.Session
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStoreFile
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.downloader.PRDownloader
import com.downloader.PRDownloaderConfig
import com.vashaacademy.navigation.SetUpNavHost
import com.vashaacademy.session.AuthSession
import com.vashaacademy.ui.theme.VashaAcademyTheme
import com.vashaacademy.viewmodels.VashaViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val config = PRDownloaderConfig.Builder()
            .setDatabaseEnabled(true)
            .build()
        PRDownloader.initialize(applicationContext, config)
        enableEdgeToEdge()

        val dataStore = PreferenceDataStoreFactory.create(
            corruptionHandler = ReplaceFileCorruptionHandler(produceNewData = { emptyPreferences() }),
            produceFile = { applicationContext.preferencesDataStoreFile("VashaAcademy") }
        )

        setContent {

            val vashaViewModel: VashaViewModel = viewModel<VashaViewModel>()
            vashaViewModel.setSession(AuthSession(dataStore = dataStore))
            
            VashaAcademyTheme(
                darkTheme = true
            ){
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    print(innerPadding)
                    val navController = rememberNavController()
                    SetUpNavHost(navController = navController)
//                    WelcomeScreen()
//                    HomeScreenWithDrawer()
//                    TakeExamScreen()
                }
            }
        }
    }
}
