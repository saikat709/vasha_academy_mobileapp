package com.vashaacademy.viewmodels

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.datastore.core.DataStore
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vashaacademy.session.AuthSession

object VashaViewModel: ViewModel() {
    val currentExamId = MutableLiveData<Int>(0)
    val currentCourseId = MutableLiveData<Int>(0)
    val currentQuestionIndex = MutableLiveData<Int>(0)

    var session: AuthSession? = null

    fun setSession(newSession: AuthSession){
        session = newSession
    }

    fun nextQuestion(){
        if (currentQuestionIndex.value!! < 10)
            currentQuestionIndex.value = currentQuestionIndex.value!! + 1
    }

    fun previosQuestion(){
        if (currentQuestionIndex.value!! >0)
            currentQuestionIndex.value = currentQuestionIndex.value!! - 1
    }
}