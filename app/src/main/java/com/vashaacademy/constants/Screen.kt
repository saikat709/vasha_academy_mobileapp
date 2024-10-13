package com.vashaacademy.constants

import android.net.Uri
import com.vashaacademy.backend.PdfBook

sealed class Screen(val route: String) {
    data object Home: Screen("/home")
    data object Login: Screen("/login")
    data object Verification: Screen("/verification")
    data object Welcome: Screen("/welcome")
    data object Exam: Screen("/exam")
    data object Course: Screen("/course")
    data object Faq: Screen("/faq")
    data object ReadPdf: Screen("/read_pdf/{title}/{pdf}"){
        fun getUrl(pdfBook: PdfBook): String {
            return "/read_pdf/${pdfBook.title}/${Uri.encode(pdfBook.pdf)}"
        }
    }
}