package com.vashaacademy.screens

import android.app.Activity
import android.content.pm.ActivityInfo
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import com.vashaacademy.components.ExamScreenTabs
import com.vashaacademy.components.QuestionViewScreen
import com.vashaacademy.components.QuestionsCollection
import com.vashaacademy.constants.CurrentQuestionType
import com.vashaacademy.constants.Screen

enum class ExamScreen{
    Collection, View
}

@Composable
fun TakeExamScreen(
    navController:NavHostController?=null,

) {
    val activity = LocalContext.current as Activity
    activity.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE

    var currentScreen by remember { mutableStateOf(ExamScreen.Collection) }
//    var activeTab by remember { mutableStateOf(CurrentQuestionType.Total) }

    Scaffold{
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            ExamScreenTabs(
                onNavBack = {
                    if (currentScreen == ExamScreen.View) {
                        currentScreen = ExamScreen.Collection
                    } else {
                        navController?.navigate(route = Screen.Course.route)
                    }
                },
//                currentQuestionType = activeTab,
//                onTabChange = {activeTab=it}
            )

            when(currentScreen){
                ExamScreen.Collection -> {
                    QuestionsCollection(
                        onQuestionClick = {
                            // viewmodel.current question it
                            currentScreen = ExamScreen.View
                        }
                    )
                }
                ExamScreen.View -> {
                    QuestionViewScreen()
                }
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun TakeExamScreenPrev() {
    TakeExamScreen()
}