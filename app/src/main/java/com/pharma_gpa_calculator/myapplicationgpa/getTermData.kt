package com.pharma_gpa_calculator.myapplicationgpa

import android.content.SharedPreferences
import android.content.res.Resources
import android.view.View
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.*
import com.toptoche.searchablespinnerlibrary.SearchableSpinner


class getTermData() {


    constructor(spinner: Spinner, arrayAdapter: ArrayAdapter<String>, textView: TextView) : this() {


        spinner.adapter = arrayAdapter
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                setText(p2 - 1, textView)
            }

        }

    }

    constructor(spinner: Spinner, arrayAdapter: ArrayAdapter<String>, textView: TextView, int: Int) : this() {


        spinner.adapter = arrayAdapter
        spinner.setSelection(int)
        setText(int, textView)
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                setText(p2 - 1, textView)
            }

        }
    }


    fun getPoints(grade: Int?): Double {

        return when (grade) {
            in 0..59 -> 0.0
            in 60..62 -> 1.0
            in 63..64 -> 1.3
            in 65..67 -> 2.0
            in 68..72 -> 2.3
            in 73..74 -> 2.5
            in 75..77 -> 2.7
            in 78..82 -> 3.0
            in 83..84 -> 3.3
            in 85..89 -> 3.7
            in 90..100 -> 4.0
            else -> 0.0
        }

    }


    fun setText(po: Int, hourTextView: TextView) {

        if (po == 3 || po == 9 || po == 10 || po == 13 || po == 28 || po == 34 || po == 35 || po == 43 || po == 46 || po == 60 || po == 67 || po == 69 || po == 72) {

            hourTextView.text = "1"
        } else if (po == 6 || po == 7 || po == 8 || po == 11 || po == 12 || po == 14 || po == 15 || po == 18 || po == 19 || po == 21 || po == 22 || po == 24 || po == 25 ||
                po == 26 || po == 32 || po == 33 || po == 36 || po == 37 || po == 38 || po == 39 || po == 58 || po == 66 || po == 68 || po == 71 || po == 73) {
            hourTextView.text = "2"
        } else if (po == 0 || po == 1 || po == 2 || po == 4 || po == 5 || po == 16 || po == 17 || po == 20 || po == 23 || po == 27 || po == 31 || po == 40 || po == 41 || po == 42 ||
                po == 44 || po == 45 || po == 47 || po == 48 || po == 49 || po == 50 || po == 51 || po == 52 || po == 53 || po == 54 || po == 55 || po == 56 || po == 57 ||
                po == 59 || po == 61 || po == 62 || po == 63 || po == 64 || po == 65 || po == 70 || po == 74 || po == 75) {
            hourTextView.text = "3"
        } else if (po == 29 || po == 30) {
            hourTextView.text = "4"
        } else hourTextView.text = null


    }

}


data class getResultsClass(var points: Double, var hours: Int, var gpa: Double) {

    var term1Points: Double? = null
    var term1TotalHours: Int? = null
    var termDataObject = getTermData()


    fun getCalculation(textView1: TextView, editText1: EditText, textView2: TextView, editText2: EditText, textView3: TextView, editText3: EditText, textView4: TextView, editText4: EditText, textView5: TextView, editText5: EditText, textView6: TextView, editText6: EditText, textView7: TextView, editText7: EditText, textView8: TextView, editText8: EditText, textView9: TextView, editText9: EditText, textView10: TextView, editText10: EditText): getResultsClass {

        val hour1 = if (textView1.text == null || textView1.text.toString().isEmpty()) 0 else textView1.text.toString().toInt()
        val hour2 = if (textView2.text == null || textView2.text.toString().isEmpty()) 0 else textView2.text.toString().toInt()
        val hour3 = if (textView3.text == null || textView3.text.toString().isEmpty()) 0 else textView3.text.toString().toInt()
        val hour4 = if (textView4.text == null || textView4.text.toString().isEmpty()) 0 else textView4.text.toString().toInt()
        val hour5 = if (textView5.text == null || textView5.text.toString().isEmpty()) 0 else textView5.text.toString().toInt()
        val hour6 = if (textView6.text == null || textView6.text.toString().isEmpty()) 0 else textView6.text.toString().toInt()
        val hour7 = if (textView7.text == null || textView7.text.toString().isEmpty()) 0 else textView7.text.toString().toInt()
        val hour8 = if (textView8.text == null || textView8.text.toString().isEmpty()) 0 else textView8.text.toString().toInt()
        val hour9 = if (textView9.text == null || textView9.text.toString().isEmpty()) 0 else textView9.text.toString().toInt()
        val hour10 = if (textView10.text == null || textView10.text.toString().isEmpty()) 0 else textView10.text.toString().toInt()

        val points1 = termDataObject.getPoints(if (editText1.text == null || editText1.text.toString().isEmpty()) 0 else editText1.text.toString().toInt()) * hour1
        val points2 = termDataObject.getPoints(if (editText2.text == null || editText2.text.toString().isEmpty()) 0 else editText2.text.toString().toInt()) * hour2
        val points3 = termDataObject.getPoints(if (editText3.text == null || editText3.text.toString().isEmpty()) 0 else editText3.text.toString().toInt()) * hour3
        val points4 = termDataObject.getPoints(if (editText4.text == null || editText4.text.toString().isEmpty()) 0 else editText4.text.toString().toInt()) * hour4
        val points5 = termDataObject.getPoints(if (editText5.text == null || editText5.text.toString().isEmpty()) 0 else editText5.text.toString().toInt()) * hour5
        val points6 = termDataObject.getPoints(if (editText6.text == null || editText6.text.toString().isEmpty()) 0 else editText6.text.toString().toInt()) * hour6
        val points7 = termDataObject.getPoints(if (editText7.text == null || editText7.text.toString().isEmpty()) 0 else editText7.text.toString().toInt()) * hour7
        val points8 = termDataObject.getPoints(if (editText8.text == null || editText8.text.toString().isEmpty()) 0 else editText8.text.toString().toInt()) * hour8
        val points9 = termDataObject.getPoints(if (editText9.text == null || editText9.text.toString().isEmpty()) 0 else editText9.text.toString().toInt()) * hour9
        val points10 = termDataObject.getPoints(if (editText10.text == null || editText10.text.toString().isEmpty()) 0 else editText10.text.toString().toInt()) * hour10

        term1Points = points1 + points2 + points3 + points4 + points5 + points6 + points7 + points8 + points9 + points10
        term1TotalHours = hour1 + hour2 + hour3 + hour4 + hour5 + hour6 + hour7 + hour8 + hour9 + hour10

        val term1GPA: Double
        if (term1TotalHours!! > 0) {
            term1GPA = term1Points!! / term1TotalHours!!
        } else {
            term1GPA = 0.00
        }


        return getResultsClass(points = term1Points!!, hours = term1TotalHours!!, gpa = term1GPA)

    }

    fun cGPAWithoutNanError(totalPonts: Double?, totalHours: Int?): Double {

        return if (totalHours != null && totalHours > 0) {

            var cGPA = totalPonts!! / totalHours!!

            cGPA
        } else 0.0


    }




}




