package com.example.mctcsurveyapp

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class SurveyResultsFragment : Fragment() {
    private lateinit var yesTotalTextView: TextView
    private lateinit var noTotalTextView: TextView
    private lateinit var resetButton: Button
    private lateinit var continueButton: Button

    // This is needed to initialize the

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // TODO set fragment content view?

        initWidgets()
        getTotalsFromIntent()
        setOnClickListeners()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_survey_results, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SurveyResultsFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SurveyResultsFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
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
        setResult(AppCompatActivity.RESULT_OK, resultIntent)
        finish()
    }

}