package com.example.mctcsurveyapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

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
//    private lateinit var resultButton: Button
    //
//    private val resultScreenLauncher =
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
        val view =  inflater.inflate(R.layout.fragment_question_response, container, false)
        // note that widgets need to be initialized with regards to the  view within the fragment before setting the Listeners
        initializeWidgets(view)
        setListeners()
        return view

    }


//    // recall count updates from saved instance state
//    noCount = savedInstanceState?.getInt(NO_COUNT_KEY) ?: 0
//    yesCount = savedInstanceState?.getInt(YES_COUNT_KEY) ?: 0

//        updateCounts()


    // save instance state for noCount and yesCount variables.
//    override fun onSaveInstanceState(outState: Bundle) {
//        super.onSaveInstanceState(outState)
//        outState.putInt(NO_COUNT_KEY, surveyViewModel.noCount)
//        outState.putInt(YES_COUNT_KEY, surveyViewModel.yesCount)
//}





    private fun setListeners() {
        // Note that the TextView "surveyQuestion" is not a variable here,
        // because it is not interacted with in the program.
        yesButton.setOnClickListener {
            surveyViewModel.yesCountPlusOne()
        }

        noButton.setOnClickListener {
            surveyViewModel.noCountPlusOne()
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


    private fun initializeWidgets(view: View) {
        yesButton = view.findViewById(R.id.yesButton)
        noButton = view.findViewById(R.id.noButton)

        // removed 2/8/23 for new results screen
        //        resetButton = findViewById(R.id.resetButton)
//        yesCountTextView = findViewById(R.id.yesTotal)
//        noCountTextView = findViewById(R.id.noTotal)
    }
    companion object {
        // helper that belongs to fragment class
        // might need to know things about the fragment before it is created.
        // that's what this is for  - "static" things (Java)
        @JvmStatic  // JavaVirtualMachineStatic
        fun newInstance() = QuestionResponseFragment()
    }

}
