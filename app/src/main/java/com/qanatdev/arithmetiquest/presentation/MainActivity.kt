package com.qanatdev.arithmetiquest.presentation

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.qanatdev.arithmetiquest.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        launchWelcomeActivity()
    }

    private fun launchWelcomeActivity(){
        val prefs: SharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val firstRun: Boolean = prefs.getBoolean(KEY_FIRST_RUN, true)

        if (firstRun) {
            startActivity(Intent(this, WelcomeActivity::class.java))
        }
    }

    companion object{
        private val PREFS_NAME = "MyPrefsFile"
        private val KEY_FIRST_RUN = "firstRun"
    }
}
