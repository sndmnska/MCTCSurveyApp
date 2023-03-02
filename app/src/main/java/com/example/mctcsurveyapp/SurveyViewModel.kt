package com.example.mctcsurveyapp

import androidx.lifecycle.ViewModel

// Create a viewModel to send data back and forth


class SurveyViewModel: ViewModel() {
    // list the data that can change
    var yesCount = 0
    var noCount = 0


    // list quick functions that affect this viewmodel
    fun resetStatus() {
        yesCount = 0
        noCount = 0
    }
}