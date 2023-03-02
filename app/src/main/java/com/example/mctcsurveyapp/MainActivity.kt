package com.example.mctcsurveyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment

// Keys to be able to save two variables in instance states.



class MainActivity : AppCompatActivity() {

    // All that's needed here is to set the content view based on activity_main.
    // The fragments contained within will take care of themselves
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}