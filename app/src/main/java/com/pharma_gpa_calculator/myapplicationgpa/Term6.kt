package com.pharma_gpa_calculator.myapplicationgpa

import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ImageView
import kotlinx.android.synthetic.main.term_activity.*

class Term6 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.term_activity)

        var termImage=findViewById<ImageView>(R.id.term_ImageView)
        termImage.setImageResource(R.drawable.level3_term2_65)
        //تعريف array من xml و تعريف adapter

        val coursesList = resources.getStringArray(R.array.courses_array)!!
        val courseAdapter = ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, coursesList)
        courseAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        //خصصنا الادابتر للسبنر وعرضناه فى تيكست فيو عبر كلاس اخر

        getTermData(sp1, courseAdapter, hour1,65)
        getTermData(sp2, courseAdapter, hour2,10)
        getTermData(sp3, courseAdapter, hour3,19)
        getTermData(sp4, courseAdapter, hour4,57)
        getTermData(sp5, courseAdapter, hour5,48)
        getTermData(sp6, courseAdapter, hour6,38)
        getTermData(sp7, courseAdapter, hour7)
        getTermData(sp8, courseAdapter, hour8)
        getTermData(sp9, courseAdapter, hour9)
        getTermData(sp10, courseAdapter, hour10)

        //استرجاع قيمة الايديت تيكست المحفوظة مسبقا

        val saveData: SharedPreferences = getSharedPreferences("PharmaGPA", 0)
        grade_et1.setText(saveData.getString("t6_gr1", "").toString())
        grade_et2.setText(saveData.getString("t6_gr2", "").toString())
        grade_et3.setText(saveData.getString("t6_gr3", "").toString())
        grade_et4.setText(saveData.getString("t6_gr4", "").toString())
        grade_et5.setText(saveData.getString("t6_gr5", "").toString())
        grade_et6.setText(saveData.getString("t6_gr6", "").toString())
        grade_et7.setText(saveData.getString("t6_gr7", "").toString())
        grade_et8.setText(saveData.getString("t6_gr8", "").toString())
        grade_et9.setText(saveData.getString("t6_gr9", "").toString())
        grade_et10.setText(saveData.getString("t6_gr10", "").toString())

        //استرجاع قيمة spinner المحفوظة مسبقا

        sp1.setSelection(saveData.getInt("t6_sp1", 65))
        sp2.setSelection(saveData.getInt("t6_sp2", 10))
        sp3.setSelection(saveData.getInt("t6_sp3", 19))
        sp4.setSelection(saveData.getInt("t6_sp4", 57))
        sp5.setSelection(saveData.getInt("t6_sp5", 48))
        sp6.setSelection(saveData.getInt("t6_sp6", 38))
        sp7.setSelection(saveData.getInt("t6_sp7", 0))
        sp8.setSelection(saveData.getInt("t6_sp8", 0))
        sp9.setSelection(saveData.getInt("t6_sp9", 0))
        sp10.setSelection(saveData.getInt("t6_sp10", 0))

        gpa_text_view.text = saveData.getString("t6_gpa", "0.00").toString()
        cGPA_text_view.text = saveData.getString("t6_cgpa", "0.00").toString()

        prev_term_button.setOnClickListener {
            val showPrevTerm = Intent(this, Term5::class.java)
            finish()
            startActivity(showPrevTerm)
        }

        next_term_button.setOnClickListener {
            val showNextTerm = Intent(this, Summer3::class.java)
            finish()
            startActivity(showNextTerm)
        }

    }

    fun getDisplayTermData(view: View) {

        //استخدامة دالة لحساب gpa  والتحقق من null
        displayTermData()


    }

    private fun displayTermData() {

        val getResultsClass = getResultsClass(0.0, 0, 0.0)
        val Results = getResultsClass.getCalculation(hour1, grade_et1, hour2, grade_et2, hour3, grade_et3, hour4, grade_et4, hour5, grade_et5, hour6, grade_et6, hour7, grade_et7, hour8, grade_et8, hour9, grade_et9, hour10, grade_et10)

        //عرضنا النواتج فى التيكست فيو الخاص بها

        val saveData: SharedPreferences = getSharedPreferences("PharmaGPA", 0)

        val prevTermHour = saveData.getInt("t5_total_hour", 0)
        val prevTermPoints = saveData.getString("t5_total_points", "0").toDouble()

        val totalHours = prevTermHour + Results.hours
        val totalPoints = prevTermPoints + Results.points
        val cGPA =getResultsClass.cGPAWithoutNanError(totalPoints,totalHours)

        gpa_text_view.text = ("%.2f".format(Results.gpa))
        cGPA_text_view.text = ("%.2f".format(cGPA))

        //حفظ القيم عند الضغط على الزر

        saveData.edit().putString("t6_gr1", grade_et1.text.toString()).apply()
        saveData.edit().putString("t6_gr2", grade_et2.text.toString()).apply()
        saveData.edit().putString("t6_gr3", grade_et3.text.toString()).apply()
        saveData.edit().putString("t6_gr4", grade_et4.text.toString()).apply()
        saveData.edit().putString("t6_gr5", grade_et5.text.toString()).apply()
        saveData.edit().putString("t6_gr6", grade_et6.text.toString()).apply()
        saveData.edit().putString("t6_gr7", grade_et7.text.toString()).apply()
        saveData.edit().putString("t6_gr8", grade_et8.text.toString()).apply()
        saveData.edit().putString("t6_gr9", grade_et9.text.toString()).apply()
        saveData.edit().putString("t6_gr10", grade_et10.text.toString()).apply()

        saveData.edit().putInt("t6_sp1", sp1.selectedItemPosition).apply()
        saveData.edit().putInt("t6_sp2", sp2.selectedItemPosition).apply()
        saveData.edit().putInt("t6_sp3", sp3.selectedItemPosition).apply()
        saveData.edit().putInt("t6_sp4", sp4.selectedItemPosition).apply()
        saveData.edit().putInt("t6_sp5", sp5.selectedItemPosition).apply()
        saveData.edit().putInt("t6_sp6", sp6.selectedItemPosition).apply()
        saveData.edit().putInt("t6_sp7", sp7.selectedItemPosition).apply()
        saveData.edit().putInt("t6_sp8", sp8.selectedItemPosition).apply()
        saveData.edit().putInt("t6_sp9", sp9.selectedItemPosition).apply()
        saveData.edit().putInt("t6_sp10", sp10.selectedItemPosition).apply()

        saveData.edit().putInt("t6_hour", Results.hours).apply()
        saveData.edit().putString("t6_gpa", "%.2f".format(Results.gpa)).apply()
        saveData.edit().putString("t6_cgpa", "%.2f".format(cGPA)).apply()
        saveData.edit().putString("t6_points", Results.points.toString()).apply()

        saveData.edit().putInt("t6_total_hour", totalHours).apply()
        saveData.edit().putString("t6_total_points", totalPoints.toString()).apply()


    }


    override fun onDestroy() {
        super.onDestroy()
        displayTermData()
    }


}











