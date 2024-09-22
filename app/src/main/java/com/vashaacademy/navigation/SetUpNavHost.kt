package com.vashaacademy.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.vashaacademy.constants.Screen
import com.vashaacademy.screens.CourseScreen
import com.vashaacademy.screens.HomeScreen
import com.vashaacademy.screens.HomeScreenWithDrawer
import com.vashaacademy.screens.LoginScreen
import com.vashaacademy.screens.TakeExamScreen
import com.vashaacademy.screens.VerificationScreen
import com.vashaacademy.screens.WelcomeScreen

@Composable
fun SetUpNavHost(
    modifier: Modifier = Modifier,
    navController: NavHostController,
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Welcome.route
    ){
        composable(
            route = Screen.Home.route,
        ){
            HomeScreenWithDrawer(navController=navController)
        }

        composable(
            route = Screen.Welcome.route
        ){
            WelcomeScreen(navController = navController)
        }

        composable(
            route = Screen.Login.route
        ){
            LoginScreen(navController = navController)
        }

        composable(
            route = Screen.Verification.route
        ){
            VerificationScreen(navController = navController)
        }

        composable(
            route = Screen.Course.route
        ){
            CourseScreen(navController = navController)
        }

        composable(
            route = Screen.Exam.route
        ){
            TakeExamScreen(navController = navController)
        }

    }
}