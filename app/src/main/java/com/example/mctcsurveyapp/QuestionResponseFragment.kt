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
import androidx.lifecycle.ViewModelProvider

/**
 * A simple [Fragment] subclass.
 * Use the [QuestionResponseFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

const val YES_COUNT_KEY = "yes-count-bundle-key"
const val NO_COUNT_KEY = "no-count-bundle-key"
class QuestionResponseFragment : Fragment() {
    private lateinit var yesButton: Button
    private lateinit var noButton: Button
    //    private lateinit var resetButton: Button // removed 2/8/23
//    private lateinit var yesCountTextView: TextView
//    private lateinit var noCountTextView: TextView
//    private lateinit var resultButton: Button

//    private val resultScreenLauncher =
//        /* TODO: This might not mean much in this case.  This applies to Activities, in which we are attempting
//            to put two fragments in to a single activity.
//         */
//        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
//            handleResetResult(result)
//        }

    // Initialize the count totals to start a zero.



    // Let's create a ViewModel for the fragments here.  This... should go across both models...
    val surveyViewModel: SurveyViewModel by lazy {
        ViewModelProvider(requireActivity()).get(SurveyViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_question_response, container, true)
        initializeWidgets(view)
        setListeners()
        return view

    }


//    // recall count updates from saved instance state
//    noCount = savedInstanceState?.getInt(NO_COUNT_KEY) ?: 0
//    yesCount = savedInstanceState?.getInt(YES_COUNT_KEY) ?: 0

//        updateCounts()


    // save instance state for noCount and yesCount variables.
    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt(NO_COUNT_KEY, surveyViewModel.noCount)
        outState.putInt(YES_COUNT_KEY, surveyViewModel.yesCount)


    }



    private fun setListeners() {
        // Note that the TextView "surveyQuestion" is not a variable here,
        // because it is not interacted with in the program.
        yesButton.setOnClickListener {
            surveyViewModel.yesCount += 1  // increments yesCount
            TODO("Update Counts function")
            updateCounts()
        }

        noButton.setOnClickListener {
            surveyViewModel.noCount += 1 // increments noCount
            TODO("Update Counts function")
            updateCounts()
        }

        /*  Unnecessary */
//        resultButton.setOnClickListener {
//            // Send noCount and yesCount to SurveyResultActivity, go to that Activity
//            val showResultsIntent = Intent(this, surveyViewModel)
//            showResultsIntent.putExtra(EXTRA_YES_COUNT, yesCount)
//            showResultsIntent.putExtra(EXTRA_NO_COUNT, noCount)
//            resultScreenLauncher.launch(showResultsIntent)
//    }


    }
    fun updateCounts() {
        TODO("Connect TextViews with SurveyResultsFragment, somehow." +
                "Either figure out a way to send the data over, such as via .putExtra()" +
                "or get some other way to send the data to the Fragment.")
        // In the old version, this simply updated values that were live on the screen.
        // In the new version, this is probably best in the surveyResultsFragment.

        val intent = Intent()
        intent.putExtra(YES_COUNT_KEY, surveyViewModel.yesCount)
        intent.putExtra(NO_COUNT_KEY,surveyViewModel.noCount)


//        yesTotalTextView.text = getString(R.string.yes_total, surveyViewModel.yesCount)
//        noTotalTextView.text = getString(R.string.no_total, surveyViewModel.noCount)
    }


//    private fun handleResetResult(result: ActivityResult) {
//        // take data from SurveyResultActivity, and execute reset if true
//        // only execute if resultCode is RESULT_OK. Then resets should only happen when intended.
//        if (result.resultCode == AppCompatActivity.RESULT_OK) {
//            val intent = result.data
//            val reset = intent?.getBooleanExtra(EXTRA_RESET_BUTTON, false) ?: false
//            if (reset) {
//                yesCount = 0
//                noCount = 0
//                Toast.makeText(
//                        this, getString(R.string.reset_message), Toast.LENGTH_SHORT
//                ).show()
//            }
//        }
////        else if (result.resultCode == RESULT_CANCELED) {
//            //  ** Do nothing.
//            // it can be assumed that hitting the "back" button means no
//            // changes such as a reset are intended.
//        }

    companion object {
        @JvmStatic
        fun newInstance() = QuestionResponseFragment()
    }

    private fun initializeWidgets(view: View) {
        yesButton = view.findViewById(R.id.yesButton)
        noButton = view.findViewById(R.id.noButton)

        // removed 2/8/23 for new results screen
        //        resetButton = findViewById(R.id.resetButton)
//        yesCountTextView = findViewById(R.id.yesTotal)
//        noCountTextView = findViewById(R.id.noTotal)
    }
}
