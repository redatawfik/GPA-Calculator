package com.pharma_gpa_calculator.myapplicationgpa

import android.content.Intent
import android.content.SharedPreferences
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ImageView
import com.toptoche.searchablespinnerlibrary.SearchableSpinner
import kotlinx.android.synthetic.main.term_activity.*

class Term1 : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.term_activity)


        var termImage=findViewById<ImageView>(R.id.term_ImageView)
        termImage.setImageResource(R.drawable.level1_term1_65)
        //تعريف array من xml و تعريف adapter

        val coursesList = resources.getStringArray(R.array.courses_array)!!
        val courseAdapter = ArrayAdapter<String>(this, R.layout.support_simple_spinner_dropdown_item, coursesList)
        courseAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)

        //خصصنا الادابتر للسبنر وعرضناه فى تيكست فيو عبر كلاس اخر

        getTermData(sp1, courseAdapter, hour1, 27)
        getTermData(sp2, courseAdapter, hour2, 61)
        getTermData(sp3, courseAdapter, hour3, 49)
        getTermData(sp4, courseAdapter, hour4, 59)
        getTermData(sp5, courseAdapter, hour5, 29)
        getTermData(sp6, courseAdapter, hour6, 13)
        getTermData(sp7, courseAdapter, hour7)
        getTermData(sp8, courseAdapter, hour8)
        getTermData(sp9, courseAdapter, hour9)
        getTermData(sp10, courseAdapter, hour10)

        //استرجاع قيمة الايديت تيكست المحفوظة مسبقا

        val saveData: SharedPreferences = getSharedPreferences("PharmaGPA", 0)
        grade_et1.setText(saveData.getString("t1_gr1", "").toString())
        grade_et2.setText(saveData.getString("t1_gr2", "").toString())
        grade_et3.setText(saveData.getString("t1_gr3", "").toString())
        grade_et4.setText(saveData.getString("t1_gr4", "").toString())
        grade_et5.setText(saveData.getString("t1_gr5", "").toString())
        grade_et6.setText(saveData.getString("t1_gr6", "").toString())
        grade_et7.setText(saveData.getString("t1_gr7", "").toString())
        grade_et8.setText(saveData.getString("t1_gr8", "").toString())
        grade_et9.setText(saveData.getString("t1_gr9", "").toString())
        grade_et10.setText(saveData.getString("t1_gr10", "").toString())

        //استرجاع قيمة spinner المحفوظة مسبقا

        sp1.setSelection(saveData.getInt("t1_sp1", 27))
        sp2.setSelection(saveData.getInt("t1_sp2", 61))
        sp3.setSelection(saveData.getInt("t1_sp3", 49))
        sp4.setSelection(saveData.getInt("t1_sp4", 59))
        sp5.setSelection(saveData.getInt("t1_sp5", 29))
        sp6.setSelection(saveData.getInt("t1_sp6", 13))
        sp7.setSelection(saveData.getInt("t1_sp7", 0))
        sp8.setSelection(saveData.getInt("t1_sp8", 0))
        sp9.setSelection(saveData.getInt("t1_sp9", 0))
        sp10.setSelection(saveData.getInt("t1_sp10", 0))

        gpa_text_view.text = saveData.getString("t1_gpa", "0.00").toString()
        cGPA_text_view.text = saveData.getString("t1_cgpa", "0.00").toString()

        next_term_button.setOnClickListener {
            val showNextTerm = Intent(this, Term2::class.java)
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

        gpa_text_view.text = ("%.2f".format(Results.gpa))
        cGPA_text_view.text = ("%.2f".format(Results.gpa))

        //حفظ القيم عند الضغط على الزر

        val saveData: SharedPreferences = getSharedPreferences("PharmaGPA", 0)
        saveData.edit().putString("t1_gr1", grade_et1.text.toString()).apply()
        saveData.edit().putString("t1_gr2", grade_et2.text.toString()).apply()
        saveData.edit().putString("t1_gr3", grade_et3.text.toString()).apply()
        saveData.edit().putString("t1_gr4", grade_et4.text.toString()).apply()
        saveData.edit().putString("t1_gr5", grade_et5.text.toString()).apply()
        saveData.edit().putString("t1_gr6", grade_et6.text.toString()).apply()
        saveData.edit().putString("t1_gr7", grade_et7.text.toString()).apply()
        saveData.edit().putString("t1_gr8", grade_et8.text.toString()).apply()
        saveData.edit().putString("t1_gr9", grade_et9.text.toString()).apply()
        saveData.edit().putString("t1_gr10", grade_et10.text.toString()).apply()

        saveData.edit().putInt("t1_sp1", sp1.selectedItemPosition).apply()
        saveData.edit().putInt("t1_sp2", sp2.selectedItemPosition).apply()
        saveData.edit().putInt("t1_sp3", sp3.selectedItemPosition).apply()
        saveData.edit().putInt("t1_sp4", sp4.selectedItemPosition).apply()
        saveData.edit().putInt("t1_sp5", sp5.selectedItemPosition).apply()
        saveData.edit().putInt("t1_sp6", sp6.selectedItemPosition).apply()
        saveData.edit().putInt("t1_sp7", sp7.selectedItemPosition).apply()
        saveData.edit().putInt("t1_sp8", sp8.selectedItemPosition).apply()
        saveData.edit().putInt("t1_sp9", sp9.selectedItemPosition).apply()
        saveData.edit().putInt("t1_sp10", sp10.selectedItemPosition).apply()

        saveData.edit().putInt("t1_hour", Results.hours).apply()
        saveData.edit().putString("t1_gpa", "%.2f".format(Results.gpa)).apply()
        saveData.edit().putString("t1_cgpa", "%.2f".format(Results.gpa)).apply()
        saveData.edit().putString("t1_points", Results.points.toString()).apply()



    }


    override fun onDestroy() {
        super.onDestroy()
        displayTermData()
    }





}











