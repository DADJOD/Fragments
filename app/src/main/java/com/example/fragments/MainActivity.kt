package com.example.fragments

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.FrameLayout
import androidx.fragment.app.FragmentTransaction

class MainActivity : AppCompatActivity() {
    private lateinit var fragment: MyFragment
    private lateinit var transaction: FragmentTransaction
    private lateinit var nest: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Logger.logMe()

        nest = findViewById(R.id.nest)
    }

    override fun onStart() {
        super.onStart()
        Logger.logMe()

        val manager = supportFragmentManager        // give fragmentManager

        if (nest.childCount == 0) {
            transaction = manager.beginTransaction()    // start transaction

//            val bundleForFragment = Bundle()                // for send key\values
//            bundleForFragment.putString("param1", "qqq")
//
//            val fragment = MyFragment()
//            fragment.arguments = bundleForFragment

//            transaction.add(R.id.nest, fragment)        // add or remove fragments
//            transaction.commit()                        // finish transaction

            fragment = MyFragment().getInstance("qqq ${hashCode()}")

            transaction.add(R.id.nest, fragment)        // add or remove fragments
            transaction.commit()                        // finish transaction
        } else {
            Logger.logSomething("already have the fragment")

            fragment = manager.findFragmentById(R.id.nest) as MyFragment
        }
    }

    override fun onResume() {
        super.onResume()
        Logger.logMe()

        fragment.setMessage("added")
    }
}