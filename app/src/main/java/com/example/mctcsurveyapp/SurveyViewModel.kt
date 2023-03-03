package com.example.mctcsurveyapp

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

// Create a viewModel to send data back and forth


class SurveyViewModel: ViewModel() {
    // list the data that can change
    val yesCount = MutableLiveData<Int>(0)
    val noCount = MutableLiveData<Int>(0)


    // list quick functions that affect this viewmodel
    fun resetStatus() {
        yesCount.value = 0
        noCount.value = 0
    }

//    surveyViewModel.yesCount.observe() {newYes -> ... }  //  Put inside applicable fragments

    fun yesCountPlusOne() {
        yesCount.value = yesCount.value!! + 1
    }
    fun noCountPlusOne() {
        noCount.value = noCount.value!! + 1 // this will never be null
    }
}