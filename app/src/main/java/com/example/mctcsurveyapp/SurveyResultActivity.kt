package com.example.mctcsurveyapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

/** This Activity is used to display the results of the survey: How many yes and no answers */

/* Brainstorming:
Display the results of the survey.  Include the reset button to set the counts to zero, and a
continue button to jump back to the original screen.

Okay, we have developed the main layout of the screen. Now we wire it up.

For the sake of ease, the reset button does not remain on this screen
*/

// This variable is sent from this activity
const val EXTRA_RESET_BUTTON = "com.example.mctcsurveyapp.RESET_BUTTON"

class SurveyResultActivity : AppCompatActivity() {
    private lateinit var yesTotalTextView: TextView
    private lateinit var noTotalTextView: TextView
    private lateinit var resetButton: Button
    private lateinit var continueButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survey_result)

        initWidgets()
        getTotalsFromIntent()
        setOnClickListeners()
    }

    private fun getTotalsFromIntent() {
        val yesTotal = intent.getIntExtra(EXTRA_YES_COUNT, 0)
        val noTotal = intent.getIntExtra(EXTRA_NO_COUNT, 0)

        // The strings are used for some formatting
        yesTotalTextView.text = getString(R.string.yes_total, yesTotal)
        noTotalTextView.text = getString(R.string.no_total, noTotal)
    }

    private fun setOnClickListeners() {
        resetButton.setOnClickListener {
            resetStatus(true)
        }
        continueButton.setOnClickListener {
            // go to the main screen, do not reset
            resetStatus(false)
        }
    }

    private fun initWidgets() {
        yesTotalTextView = findViewById(R.id.yes_total_results)
        noTotalTextView = findViewById(R.id.no_total_results)
        resetButton = findViewById(R.id.reset_button)
        continueButton = findViewById(R.id.continue_button)
    }

    private fun resetStatus(resetState: Boolean) {
        val resultIntent = Intent()
        resultIntent.putExtra(EXTRA_RESET_BUTTON, resetState) // false - do not reset
        setResult(RESULT_OK, resultIntent)
        finish()
    }

}