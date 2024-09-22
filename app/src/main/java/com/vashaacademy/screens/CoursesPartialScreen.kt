package com.vashaacademy.screens

import android.util.Log
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.vashaacademy.components.CourseTile
import com.vashaacademy.constants.Screen


@Composable
fun CoursesPartialScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController? = null
) {
    LazyVerticalGrid(
        modifier = Modifier.then(modifier),
        columns = GridCells.Fixed(2),
    ) {
        items(20){
            CourseTile(
                onEnroll = {
                    navController?.navigate(Screen.Course.route)
                    Log.d("saikat", "Click detected in Courses partial...")
                    Log.d("saikat", "nav ${navController ?: "Nulllll"}")
                }
            )
        }
    }
}

@Composable
@Preview(showBackground = true)
fun CoursesPartialScreenPrev(modifier: Modifier = Modifier) {
    CoursesPartialScreen()
}