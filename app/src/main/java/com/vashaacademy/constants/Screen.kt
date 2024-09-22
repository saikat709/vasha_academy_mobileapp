package com.vashaacademy.constants

sealed class Screen(val route: String) {
    data object Home: Screen("/home")
    data object Login: Screen("/login")
    data object Verification: Screen("/verification")
    data object Welcome: Screen("/welcome")
    data object Exam: Screen("/exam")
    data object Course: Screen("/course")
}