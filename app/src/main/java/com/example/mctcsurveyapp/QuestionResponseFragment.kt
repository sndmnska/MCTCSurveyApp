package com.example.mctcsurveyapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

/**
 * A simple [Fragment] subclass.
 * Use the [QuestionResponseFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuestionResponseFragment : Fragment() {
    private lateinit var yesButton: Button
    private lateinit var noButton: Button
    //    private lateinit var resetButton: Button // removed 2/8/23
//    private lateinit var yesCountTextView: TextView
//    private lateinit var noCountTextView: TextView
    private lateinit var resultButton: Button

    private val resultScreenLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            handleResetResult(result)
        }

    // Initialize the count totals to start a zero.
    private var yesCount = 0
    private var noCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_question_response, container, false)
    }
    initializeWidgets()
    setListeners()

    // recall count updates from saved instance state
    noCount = savedInstanceState?.getInt(NO_COUNT_KEY) ?: 0
    yesCount = savedInstanceState?.getInt(YES_COUNT_KEY) ?: 0

//        updateCounts()


    // save instance state for noCount and yesCount variables.
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(NO_COUNT_KEY, noCount)
        outState.putInt(YES_COUNT_KEY, yesCount)
    }

//    private fun updateCounts() {
//        yesCountTextView.text = getString(R.string.yes_total, yesCount)
//        noCountTextView.text = getString(R.string.no_total, noCount)
//    }

    private fun setListeners() {
        // Note that the TextView "surveyQuestion" is not a variable here,
        // because it is not interacted with in the program.
        yesButton.setOnClickListener {
            yesCount += 1 // increments yesCount
//            updateCounts()
        }

        noButton.setOnClickListener {
            noCount += 1 // increments noCount
//            updateCounts()
        }
        resultButton.setOnClickListener {
            // Send noCount and yesCount to SurveyResultActivity, go to that Activity
            val showResultsIntent = Intent(this, SurveyResultActivity::class.java)
            showResultsIntent.putExtra(EXTRA_YES_COUNT, yesCount)
            showResultsIntent.putExtra(EXTRA_NO_COUNT, noCount)
            resultScreenLauncher.launch(showResultsIntent)

        }


    }

    private fun handleResetResult(result: ActivityResult) {
        // take data from SurveyResultActivity, and execute reset if true
        // only execute if resultCode is RESULT_OK. Then resets should only happen when intended.
        if (result.resultCode == AppCompatActivity.RESULT_OK) {
            val intent = result.data
            val reset = intent?.getBooleanExtra(EXTRA_RESET_BUTTON, false) ?: false
            if (reset) {
                yesCount = 0
                noCount = 0
                Toast.makeText(
                        this, getString(R.string.reset_message), Toast.LENGTH_SHORT
                ).show()
            }
        }
//        else if (result.resultCode == RESULT_CANCELED) {
//            //  ** Do nothing.
//            // it can be assumed that hitting the "back" button means no
//            // changes such as a reset are intended.
//        }
    }

    private fun initializeWidgets() {
        yesButton = findViewById(R.id.yesButton)
        noButton = findViewById(R.id.noButton)

        // removed 2/8/23 for new results screen
        //        resetButton = findViewById(R.id.resetButton)
//        yesCountTextView = findViewById(R.id.yesTotal)
//        noCountTextView = findViewById(R.id.noTotal)
    }
}
