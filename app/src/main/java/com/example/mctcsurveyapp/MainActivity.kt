package com.example.mctcsurveyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

// Keys to be able to save two variables in instance states.
const val YES_COUNT_KEY = "yes-count-bundle-key"
const val NO_COUNT_KEY = "no-count-bundle-key"

class MainActivity : AppCompatActivity() {
    private lateinit var yesButton: Button
    private lateinit var noButton: Button
    private lateinit var resetButton: Button
    private lateinit var yesCountTextView: TextView
    private lateinit var noCountTextView: TextView

    // Initialize the count totals to start a zero.
    private var yesCount = 0
    private var noCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initializeWidgets()
        setListeners()

        // recall count updates from saved instance state
        noCount = savedInstanceState?.getInt(NO_COUNT_KEY) ?: 0
        yesCount = savedInstanceState?.getInt(YES_COUNT_KEY) ?: 0

        updateCounts()


    }
    // save instance state for noCount and yesCount variables.
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(NO_COUNT_KEY, noCount)
        outState.putInt(YES_COUNT_KEY, yesCount)
    }

    private fun updateCounts() {
        yesCountTextView.text = getString(R.string.yes_total, yesCount)
        noCountTextView.text = getString(R.string.no_total, noCount)
    }

    private fun setListeners() {
        // Note that the TextView "surveyQuestion" is not a variable here,
    // because it is not interacted with in the program.
        yesButton.setOnClickListener {
            yesCount += 1 // increments yesCount
            updateCounts()
        }

        noButton.setOnClickListener {
            noCount += 1 // increments noCount
            updateCounts()
        }

        resetButton.setOnClickListener {
            yesCount = 0
            noCount = 0
            updateCounts()
        }

    }

    private fun initializeWidgets() {
        yesButton = findViewById(R.id.yesButton)
        noButton = findViewById(R.id.noButton)
        resetButton = findViewById(R.id.resetButton)
        yesCountTextView = findViewById(R.id.yesTotal)
        noCountTextView = findViewById(R.id.noTotal)
    }
}