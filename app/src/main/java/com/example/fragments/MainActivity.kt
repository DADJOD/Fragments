package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Logger.logMe()
    }

    override fun onStart() {
        super.onStart()
        Logger.logMe()
    }

    override fun onResume() {
        super.onResume()
        Logger.logMe()
    }

    override fun onStop() {
        super.onStop()
        Logger.logMe()
    }

}