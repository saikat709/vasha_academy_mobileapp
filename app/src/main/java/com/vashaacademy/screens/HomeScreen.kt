package com.vashaacademy.screens

import android.app.Activity
import android.content.pm.ActivityInfo
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.vashaacademy.components.*

@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController? = null
) {
    val activity = LocalContext.current as Activity
    activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT

    var currentScreen = remember { mutableIntStateOf(0) }
    Scaffold(
        topBar = { TopBarWithInfo() },
        bottomBar = { BottomNavBar(screen = currentScreen) },
    ){
        when(currentScreen.intValue){
            0 -> CoursesPartialScreen(
                modifier = Modifier.padding(it)
            )
            1 -> PdfsPartialScreen(
                modifier = Modifier.padding(it)
            )
        }
    }

}

@Composable
@Preview(uiMode = UI_MODE_NIGHT_YES)
fun HomeScreenPrev(modifier: Modifier = Modifier) {
    HomeScreen()
}