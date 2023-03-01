package com.example.mctcsurveyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

// Keys to be able to save two variables in instance states.
const val YES_COUNT_KEY = "yes-count-bundle-key"
const val NO_COUNT_KEY = "no-count-bundle-key"

const val EXTRA_YES_COUNT = "com.example.mctcsurveyapp.YES_COUNT"
const val EXTRA_NO_COUNT = "com.example.mctcsurveyapp.NO_COUNT"

class MainActivity : AppCompatActivity() {

    // All that's needed here is to set the content view based on activity_main.
    // The fragments contained within will take care of themselves
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}