package com.vashaacademy.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ExamViewModel: ViewModel() {
    val currentExamId = MutableLiveData<Int>(0)
    val currentCourseId = MutableLiveData<Int>(0)
    val currentQuestionIndex = MutableLiveData<Int>(0)

    fun nextQuestion(){
        if (currentQuestionIndex.value!! < 10)
            currentQuestionIndex.value = currentQuestionIndex.value!! + 1
    }

    fun previosQuestion(){
        if (currentQuestionIndex.value!! >0)
            currentQuestionIndex.value = currentQuestionIndex.value!! - 1
    }
}