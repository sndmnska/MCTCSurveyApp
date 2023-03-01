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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        getTotalsFromIntent()
        setOnClickListeners()

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_survey_results, container, false)
        initWidgets(view) // send view to be assigned to the findViewById
        return view
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

        // It's possible this might be useful for ViewModels
    }


    private fun setOnClickListeners() {
        resetButton.setOnClickListener {
            resetStatus()
        }
        continueButton.setOnClickListener {
            // go to the main screen, do not reset
            resetStatus()
        }
    }
    fun updateCounts() {
        // In the old version, this simply updated values that were live on the screen.
        // In the new version, this is probably best in the surveyResultsFragment.

        yesTotalTextView.text = getString(R.string.yes_total, )
        noTotalTextView.text = getString(R.string.no_total, noCount)
    }


    private fun initWidgets(view: View) {
        yesTotalTextView = view.findViewById(R.id.yes_total_results)
        noTotalTextView = view.findViewById(R.id.no_total_results)
        resetButton = view.findViewById(R.id.reset_button)
        continueButton = view.findViewById(R.id.continue_button)
    }

}