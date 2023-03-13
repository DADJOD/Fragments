package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity() {

    private lateinit var myAdapter: AdapterPages
    private lateinit var pager: ViewPager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Logger.logMe()

        pager = findViewById(R.id.pager)
        myAdapter = AdapterPages(supportFragmentManager)
        pager.adapter = myAdapter
    }
}