package com.vashaacademy

import android.annotation.SuppressLint
import android.net.ConnectivityManager
import android.net.ConnectivityManager.NetworkCallback
import android.net.Network
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.window.Dialog
import androidx.datastore.core.handlers.ReplaceFileCorruptionHandler
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStoreFile
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.vashaacademy.backend.Api
import com.vashaacademy.navigation.SetUpNavHost
import com.vashaacademy.screens.ReadPdfScreen
import com.vashaacademy.session.AuthSession
import com.vashaacademy.ui.theme.VashaAcademyTheme
import com.vashaacademy.viewmodels.AuthViewModel
import com.vashaacademy.viewmodels.LangViewModel
import kotlinx.coroutines.launch


class MainActivity : ComponentActivity() {

    private lateinit var connectivityManager: ConnectivityManager
    private lateinit var networkCallback: NetworkCallback
    var authViewModel: AuthViewModel? = null
    private lateinit var snackbarHostState: SnackbarHostState

    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        val config = PRDownloaderConfig.Builder()
//            .setDatabaseEnabled(true)
//            .build()
//        PRDownloader.initialize(applicationContext, config)
//        enableEdgeToEdge()

        val dataStore = PreferenceDataStoreFactory.create(
            corruptionHandler = ReplaceFileCorruptionHandler(produceNewData = { emptyPreferences() }),
            produceFile = { applicationContext.preferencesDataStoreFile("VashaAcademy") }
        )

        val langDataStore = PreferenceDataStoreFactory.create(
            corruptionHandler = ReplaceFileCorruptionHandler(produceNewData = { emptyPreferences() }),
            produceFile = { applicationContext.preferencesDataStoreFile("lang") }
        )

        setContent {
            VashaAcademyTheme(
                darkTheme = true
            ){
                authViewModel = viewModel<AuthViewModel>().apply{
                    setSession(AuthSession(dataStore = dataStore))
                }
                val isLoading by authViewModel!!.isLoading.observeAsState()
                val scope = rememberCoroutineScope()
                val navController = rememberNavController()
                snackbarHostState = remember { SnackbarHostState() }

                val langViewModel: LangViewModel = viewModel()
                langViewModel.setLangDataStore(langDataStore)
                scope.launch { langViewModel.updateLangValue() }

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    snackbarHost = {
                        SnackbarHost(hostState = snackbarHostState)
                    }

                ) { innerPadding ->
                    print(innerPadding)
                    authViewModel!!.setErrorListener {
                        scope.launch {
                            snackbarHostState.showSnackbar(
                                message = it,
                                actionLabel = "Okay",
                                duration = SnackbarDuration.Short
                            )
                        }
                    }

                    LaunchedEffect(Unit) {
                        scope.launch {
                            val a = Api.getInstance().getCourses()
                            Log.d("saikat", a.toString())
                        }
                    }

                    SetUpNavHost(navController = navController)
                    if (isLoading == true){
                        Dialog(
                            onDismissRequest = {},
                        ) {
                            CircularProgressIndicator()
                        }
                    }
//                    WelcomeScreen()
//                    HomeScreenWithDrawer()
//                    TakeExamScreen()
//                    ReadPdfScreen(pdfLink = "S")
                }
            }
        }

    }

    override fun onStart() {
        super.onStart()
        setNetworkStateListener()
    }

    private fun setNetworkStateListener(){
        val context = applicationContext
        connectivityManager = this.getSystemService(CONNECTIVITY_SERVICE) as ConnectivityManager

        networkCallback = object: NetworkCallback(){
            override fun onAvailable(network: Network) {
//                Toast.makeText(context, "Network is connected.", Toast.LENGTH_LONG).show()
                runOnUiThread {
                    authViewModel?.setHasNetwork(true)
                }
                super.onAvailable(network)
            }
            override fun onLost(network: Network) {
//                Toast.makeText(context, "Lost connection.", Toast.LENGTH_LONG).show()
                runOnUiThread {
                    authViewModel?.setHasNetwork(false)
                }
                super.onLost(network)
            }
        }
        connectivityManager.registerDefaultNetworkCallback(networkCallback)
    }

    override fun onDestroy() {
        connectivityManager.unregisterNetworkCallback(networkCallback)
        super.onDestroy()
    }
}
