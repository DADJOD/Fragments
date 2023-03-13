package com.example.fragments

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

@Suppress("DEPRECATION")
class MyFragment: Fragment() {
    private lateinit var parameterView: TextView

    companion object {

        // this code will work in Activity
        fun getInstance(parameter: String): MyFragment {
            val bundleForFragment = Bundle()                         // for send key\values
            bundleForFragment.putString(PARAMETER, parameter)

            val fragment = MyFragment()
            fragment.arguments = bundleForFragment

            return fragment
        }

        const val PARAMETER = "param1"
    }

    // this code will work inside MyFragment
    private fun getParameter(): String? {
        val bundleForFragment = arguments                            // get fragment exp: qqq
        if (bundleForFragment != null && bundleForFragment.containsKey(PARAMETER)) {
            return bundleForFragment.getString(PARAMETER)            // get fragment with key "param1"
        }
        return "no parameter"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Logger.logMe()

        Logger.logSomething("onCreate ${hashCode()}")

        retainInstance    // will save fragment and object
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

//        val bundleForFragment = arguments                            // get fragment exp: qqq
//        if (bundleForFragment != null && bundleForFragment.containsKey(PARAMETER)) {
//            val parameter = bundleForFragment.getString(PARAMETER)   // get fragment with key "param1"
//            parameterView.text = parameter                           // set text with key - "param1" value - "qqq"
//        }

        val view = inflater.inflate(R.layout.my_fragment, container, false)
        parameterView = view.findViewById(R.id.parameter)
        parameterView.text = getParameter()                            // set text with key - "param1" value - "qqq"

        // findViewById will be here
        Logger.logMe()
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        Logger.logMe()
    }

    @SuppressLint("SetTextI18n")
    fun setMessage(msg: String) {
        if (parameterView != null) {
            parameterView.text = "${parameterView.text.toString()} | $msg"
        }
    }
}