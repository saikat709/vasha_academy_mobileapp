package com.vashaacademy.navigation

import android.net.Uri
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.vashaacademy.constants.Screen
import com.vashaacademy.screens.CourseScreen
import com.vashaacademy.screens.FaqScreen
import com.vashaacademy.screens.HomeScreen
import com.vashaacademy.screens.HomeScreenWithDrawer
import com.vashaacademy.screens.LoginScreen
import com.vashaacademy.screens.ReadPdfScreen
import com.vashaacademy.screens.TakeExamScreen
import com.vashaacademy.screens.VerificationScreen
import com.vashaacademy.screens.WelcomeScreen
import com.vashaacademy.viewmodels.LangViewModel

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

        composable(
            route = Screen.ReadPdf.route,
            arguments = listOf( navArgument("title") { type = NavType.StringType }, navArgument("pdf") { type = NavType.StringType })
        ){ backStackEntry ->
            val title = backStackEntry.arguments?.getString("title")
            val pdf = backStackEntry.arguments?.getString("pdf")
            ReadPdfScreen(
                pdfTitle = title!!,
                pdfLink = Uri.decode(pdf!!),
                navController = navController
            )
        }

        composable(
            route = Screen.Faq.route
        ){
            FaqScreen(navController = navController)
        }

    }
}