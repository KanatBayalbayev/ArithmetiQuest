package com.qanatdev.arithmetiquest.presentation

import android.content.Context
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
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
        openDialogHowToPlay()
        closeDialogHowToPlay()
        startGame()

    }

    private fun startGame(){
        binding.buttonStart.setOnClickListener {
            startActivity(MainActivity.newInstance(this))
        }
    }

    private fun openDialogHowToPlay(){
        binding.buttonHowToPlay.setOnClickListener {
            binding.overlayView.visibility = View.VISIBLE
            binding.overlayView.isClickable = false
            binding.howToPlayDialogWindow.visibility = View.VISIBLE
        }
    }

    private fun closeDialogHowToPlay(){
        binding.buttonToCloseDialog.setOnClickListener {
            binding.overlayView.visibility = View.GONE
            binding.howToPlayDialogWindow.visibility = View.GONE
        }
        binding.overlayView.setOnClickListener {
            binding.overlayView.visibility = View.GONE
            binding.overlayView.isClickable = true
            binding.howToPlayDialogWindow.visibility = View.GONE
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}