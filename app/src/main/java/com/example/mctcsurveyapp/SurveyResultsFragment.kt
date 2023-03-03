package com.example.mctcsurveyapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider



class SurveyResultsFragment : Fragment() {
    private lateinit var yesTotalTextView: TextView
    private lateinit var noTotalTextView: TextView
    private lateinit var resetButton: Button

    /* Okay, so I need to brainstorm this...  Somehow we need to wire this stuff up such that each of
    these fragments are talking with each other.  According to the RedBlueFragment practice app we developed in class
    as well as the Criminal Intent app, neither of them seem to depend on MainActivity to function.
    Indeed, the connection to MainActivity seems to be through the activity_main.xml layout file, in which
    FragmentContainers are identified and connected to the fragments themselves.

    Somehow, these fragments are able to send information back and forth.  I'm wondering if I have to
    separate out the information to some extent?

    I have noticed that some of the variables are broken from the connections between the two activities.
    I'll double check that these are generally where they're supposed to be, then attempt to send between the two.

     */

    /*After Class
    Well, we do need something in between to send the data back and forth.
    Either a ViewModel or the Activity itself should suffice well.
     */

    /**What I have learned since office hours*
    * Fragments initialize their widgets and listeners in onCreateView.  Keep an eye on those lifecycles!
    * Fragments can have observers set up in them to look at a ViewModel or Activity to
    *   act accordingly when data in either of those is changed.
    * A given fragment is only responsible for retrieving and displaying data.
    *   Calculations and data storage are the responsibility of the ViewModel, and
    *   you can call up functions in the ViewModel to process data changes. */

    val surveyViewModel: SurveyViewModel by lazy {
        ViewModelProvider(requireActivity()).get(SurveyViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)



    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_survey_results, container, false)
        initWidgets(view) // send view to be assigned to the findViewById
        setOnClickListeners()
        setObservers()
        return view
    }

    private fun setObservers() {
        surveyViewModel.yesCount.observe(requireActivity()) {newYes ->
            yesTotalTextView.text = getString(R.string.yes_total, surveyViewModel.yesCount.value)
        }
        surveyViewModel.noCount.observe(requireActivity()) {newNo ->
            noTotalTextView.text = getString(R.string.no_total, surveyViewModel.noCount.value)
        }
    }


    private fun setOnClickListeners() {
        resetButton.setOnClickListener {
            surveyViewModel.resetStatus()
        }
    }

    private fun initWidgets(view: View) {
        yesTotalTextView = view.findViewById(R.id.yes_total_results)
        noTotalTextView = view.findViewById(R.id.no_total_results)
        resetButton = view.findViewById(R.id.reset_button)
    }

}