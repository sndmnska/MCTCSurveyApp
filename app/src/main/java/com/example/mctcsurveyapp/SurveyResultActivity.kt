package com.example.mctcsurveyapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/** This Activity is used to display the results of the survey: How many yes and no answers
 *
 * This is not used for the current version of the app. */

/* @Deprecated
Brainstorming:
Display the results of the survey.  Include the reset button to set the counts to zero, and a
continue button to jump back to the original screen.

Okay, we have developed the main layout of the screen. Now we wire it up.

For the sake of ease, the reset button does not remain on this screen
*/

class SurveyResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_survey_result)


    }
}