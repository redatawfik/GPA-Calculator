package com.pharma_gpa_calculator.myapplicationgpa

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun goToTerm1(view: View) {
        val showTerm = Intent(this, Term1::class.java)
        startActivity(showTerm)
    }

    fun goToTerm2(view: View) {
        val showTerm = Intent(this, Term2::class.java)
        startActivity(showTerm)
    }

    fun goToTerm3(view: View) {
        val showTerm = Intent(this, Term3::class.java)
        startActivity(showTerm)
    }

    fun goToTerm4(view: View) {
        val showTerm = Intent(this, Term4::class.java)
        startActivity(showTerm)
    }

    fun goToTerm5(view: View) {
        val showTerm = Intent(this, Term5::class.java)
        startActivity(showTerm)
    }

    fun goToTerm6(view: View) {
        val showTerm = Intent(this, Term6::class.java)
        startActivity(showTerm)
    }

    fun goToTerm7(view: View) {
        val showTerm = Intent(this, Term7::class.java)
        startActivity(showTerm)
    }

    fun goToTerm8(view: View) {
        val showTerm = Intent(this, Term8::class.java)
        startActivity(showTerm)
    }

    fun goToTerm9(view: View) {
        val showTerm = Intent(this, Term9::class.java)
        startActivity(showTerm)
    }

    fun goToTerm10(view: View) {
        val showTerm = Intent(this, Term10::class.java)
        startActivity(showTerm)
    }

    fun goToSummer1(view: View) {
        val showSummer = Intent(this, Summer1::class.java)
        startActivity(showSummer)
    }

    fun goToSummer2(view: View) {
        val showSummer = Intent(this, Summer2::class.java)
        startActivity(showSummer)
    }

    fun goToSummer3(view: View) {
        val showSummer = Intent(this, Summer3::class.java)
        startActivity(showSummer)
    }

    fun goToSummer4(view: View) {
        val showSummer = Intent(this, Summer4::class.java)
        startActivity(showSummer)
    }

    fun goToSummer5(view: View) {
        val showSummer = Intent(this, Summer5::class.java)
        startActivity(showSummer)
    }
}
