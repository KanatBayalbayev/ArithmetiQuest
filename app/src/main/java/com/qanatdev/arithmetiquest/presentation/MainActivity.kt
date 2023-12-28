package com.qanatdev.arithmetiquest.presentation

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.qanatdev.arithmetiquest.R


class MainActivity : AppCompatActivity() {

    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        launchWelcomeActivity()
//        launchSelectDifficultyFragment()

//        val navHostFragment = supportFragmentManager.findFragmentById(R.id.main_container) as NavHostFragment
//        val navController = navHostFragment.navController
//
//        navController.navigate(R.id.selectDifficultyFragment)

//        navController= Navigation.findNavController(this,R.id.main_container)
//        NavigationUI.setupActionBarWithNavController(this,navController)
    }

//    override fun onSupportNavigateUp(): Boolean {
//        return navController.navigateUp()
//    }

    private fun launchWelcomeActivity(){
        val prefs: SharedPreferences = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
        val firstRun: Boolean = prefs.getBoolean(KEY_FIRST_RUN, true)

        if (firstRun) {
            startActivity(Intent(this, WelcomeActivity::class.java))
        }
    }


//    private fun launchSelectDifficultyFragment(){
//
//
//        supportFragmentManager.beginTransaction()
//            .replace(R.id.main_container, SelectDifficultyFragment.newInstance())
//            .addToBackStack(SelectDifficultyFragment.NAME)
//            .commit()
//    }


    companion object{
        private val PREFS_NAME = "MyPrefsFile"
        private val KEY_FIRST_RUN = "firstRun"
    }
}
