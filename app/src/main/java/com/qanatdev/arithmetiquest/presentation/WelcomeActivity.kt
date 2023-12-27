package com.qanatdev.arithmetiquest.presentation

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.qanatdev.arithmetiquest.R
import com.qanatdev.arithmetiquest.databinding.ActivityWelcomeBinding

class WelcomeActivity : AppCompatActivity() {


    private var _binding: ActivityWelcomeBinding? = null
    private val binding: ActivityWelcomeBinding
        get() = _binding ?: throw RuntimeException("ActivityWelcomeBinding == null")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityWelcomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val prefs: SharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        binding.buttonStart.setOnClickListener {
            val editor: SharedPreferences.Editor = prefs.edit()
            editor.putBoolean(KEY_FIRST_RUN, false)
            editor.apply()
            finish()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    companion object{
        private val PREFS_NAME = "MyPrefsFile"
        private val KEY_FIRST_RUN = "firstRun"
    }
}